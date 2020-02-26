
import java.awt.Point;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.ArrayList;

import tcdIO.Terminal;

public class Server extends Node {
	static final int DEFAULT_PORT = 60000;

	Terminal terminal;
	ArrayList<Topic> topics;
	ArrayList<Subscriber> subscribers;

	/*
	 * 
	 */
	Server(Terminal terminal, int port) {
		try {
			this.terminal = terminal;
			socket = new DatagramSocket(port);
			listener.go();
			topics = new ArrayList<Topic>();
			subscribers=new ArrayList<Subscriber>();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Assume that incoming packets contain a String and print the string.
	 */
	public synchronized void onReceipt(DatagramPacket packet) {
		try {
			terminal.println(packet.toString());
			int senderPort = packet.getPort();
			
			//message is from publisher
			if (senderPort <60000) {
				// getting topic and message
				StringContent content = new StringContent(packet);
				String fullMessage = content.toString();
				String tmp[] = content.toString().split("=");
				terminal.println(fullMessage);
				
				// finding topic and subscribers
				terminal.println("Finding subscribers");
				boolean topicFound = false;
				int i = 0;
				Topic topicToSend = null;
				while (!topicFound && i < topics.size()) {
					if (topics.get(i).name == tmp[0]) {// found topic
						topicToSend = topics.get(i);
						topicFound = true;
					} else {
						i++;
					}
				}
				
				// sending to subs
				terminal.println("Sending to subscribers...");
				if (!topicFound) {// topic doesn't exist must create
					Topic newTopic = new Topic(tmp[0]);
					topics.add(newTopic);
				} else {// sending to subs

					for (i = 0; i < topicToSend.subscriberList.size(); i++) {

						byte[] data = null;
						packet = null;
						data = fullMessage.getBytes();
						terminal.println("Sending packet...");
						int portNumber = topicToSend.getSub(i).portNumber;
						InetSocketAddress destAdr = new InetSocketAddress("local host", portNumber);
						packet = new DatagramPacket(data, data.length, destAdr);
						socket.send(packet);
						terminal.println("Sent to subscriber: " + portNumber);
					}
				}
				
				// responding to pub
				DatagramPacket response;
				response = (new StringContent("OK")).toDatagramPacket();
				response.setSocketAddress(packet.getSocketAddress());
				socket.send(response);
			}
			
			//message is from sub
			else if(packet.getPort() >=70000) { 
				
				//check first if topic query 
				//subscribe or unsub to topic
				StringContent content = new StringContent(packet);
				String fullMessage = content.toString();
				String tmp[] = content.toString().split("=");
				terminal.println(fullMessage);
				
				if(tmp[1].equals("subscribe")) {//sub wants to sub to a topic
					Topic topicToSubscribeTo = findTopicByName(tmp[0]);
					if(topicToSubscribeTo!=null) {
						topicToSubscribeTo.addSubscriber(packet.getPort());
					}
				}
				else if (tmp[1].equals("unsubscribe")) {//sub wants to unsub a topic 
					Topic topicToUnsubscribeTo = findTopicByName(tmp[0]);
					if(topicToUnsubscribeTo!=null) {
						topicToUnsubscribeTo.deleteSubscriber(packet.getPort());
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method finds topic by name
	public Topic findTopicByName(String name) {
		
		int i=0;
		while(i< topics.size()) {
			if(topics.get(i).name ==name) {
				return topics.get(i);
			}
		}
		return null;
	}

	//waits for contact
	public synchronized void start() throws Exception {
		terminal.println(Integer.toString(DEFAULT_PORT));
		terminal.println("Waiting for contact");
		this.wait();
	}

	
	public static void main(String[] args) {
		try {
			//set term in right screen location
			Terminal terminal = new Terminal("Server");
			Point serverLocation = new Point (1050, 400);
			terminal.setLocation(serverLocation);
			(new Server(terminal, DEFAULT_PORT)).start();
			terminal.println("Program completed");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}
