import java.net.DatagramSocket;
import java.awt.Color;
import java.awt.Point;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Scanner;

import tcdIO.*;

public class Publisher extends Node {

	static final int DEFAULT_SRC_PORT = 50000; // starting port number for publishers
	static final int DEFAULT_DST_PORT = 60000; // server port number
	static final String DEFAULT_DST_NODE = "localhost";
	static boolean finished; //loop condition used to allow for multiple pubs

	Terminal terminal;
	InetSocketAddress dstAddress;

	static int messageSerialNumber;
	static String lastMessageSent; //store last message like stop and wait

	/**
	 * Constructor
	 * 
	 * Attempts to create socket at given port and create an InetSocketAddress for
	 * the destinations
	 */
	Publisher(Terminal terminal, String dstHost, int dstPort, int srcPort) {
		try {
			this.terminal = terminal;
			dstAddress = new InetSocketAddress(dstHost, dstPort);
			socket = new DatagramSocket(srcPort);

			messageSerialNumber = 0;
			lastMessageSent = null;
			listener.go();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	//prints ack to terminal and deletes copy of stored message
	public synchronized void onReceipt(DatagramPacket packet) {
		StringContent content = new StringContent(packet);
		this.notify();
		terminal.println(content.toString());
		lastMessageSent = null; // deleting copy of last message sent as per stop and wait
		try {
			start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// sends stuff to broker/server
	public synchronized void start() throws Exception {
		// reading and compiling message
		String topic = terminal.readString("Please enter a topic:");
		topic += "=";
		topic += terminal.readString("Please enter a message:");
		topic += "=";
		topic += messageSerialNumber++; // increments serial number after concatenating to message
		lastMessageSent = topic; // storing last message sent for stop and wait style approach

		// packet stuff
		byte[] data = null;
		DatagramPacket packet = null;
		data = topic.getBytes();
		terminal.println("Sending packet...");
		packet = new DatagramPacket(data, data.length, dstAddress);

		// sending packet
		socket.send(packet);
		terminal.println("Packet sent");
		this.wait();
	}

	// asks user for topic and message and sends to dst_node
	public static void main(String[] args) {
		try {
			int srcPort = 0;
			finished = false;
			double x = 0.0;
			double y = 32.0;
			String newLine;

			while (!finished) {//while program is running
				//checking if wants more pubs
				System.out.println("Would you like another publisher?[Y/N]");
				Scanner sc = new Scanner(System.in);
				newLine = sc.nextLine();
				if (newLine.equals("Y")) {
					// setting up terminal in new location
					Terminal terminal = new Terminal("Publisher");
					Point loc = new Point((int) x, (int) y);
					terminal.setLocation(loc);
					if (x % 900 == 0 && x / 900 != 0) {
						x = 0;
						y += 200;
					} else
						x += 300;

					srcPort = terminal.readInt("Please enter your source port number over 50000" + "\n"
							+ " or a zero to close the program:");
					if (srcPort >= DEFAULT_SRC_PORT)
						(new Publisher(terminal, DEFAULT_DST_NODE, DEFAULT_DST_PORT, srcPort)).start();
					else {
						terminal.println("Window"
								+ " is closing. Goodbye.");
						terminal.dispose();

					}
				} else {
					finished = true;
					System.out.println("Exiting Program. Goodbye");
				}
			}

			
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}
