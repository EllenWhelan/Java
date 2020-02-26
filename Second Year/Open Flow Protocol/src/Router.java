import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import tcdIO.Terminal;

public class Router extends Node{

	String name;
	final int PORT_ROUTER1 = 70000;
	final int PORT_ROUTER2=700001;
	final int PORT_ROUTER3=70002;
	String messageStored;
	
	Router(int port, String name){
		try {
			this.name=name;
			socket= new DatagramSocket(port);
			listener.go();
			messageStored=null;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void onReceipt(DatagramPacket packet) {
		//the message is from controller and will send to next ruter
		if(packet.getPort()==60000) { 
			int portNumber;
			//controller will send bacl local dst as a string
			StringContent content = new StringContent(packet);
			String message = content.toString();
			if(message.equals("r1")) portNumber=PORT_ROUTER1;
			else if(message.equals("r2")) portNumber=PORT_ROUTER2;
			else  portNumber=PORT_ROUTER3;
			
			//sending onto next router 
			byte[] data = null;
			DatagramPacket newPacket = null;
			data = messageStored.getBytes();
			
			InetSocketAddress destAdr = new InetSocketAddress("local host", portNumber);
			newPacket = new DatagramPacket(data, data.length, destAdr);
			try {
				socket.send(newPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//it is message received to transmit ie from another router or end user
		else {
			//store message for sending on later
			StringContent content = new StringContent(packet);
			String message = content.toString();
			messageStored=message;
			
			
			//ask controller for dest
			String tmp[] =message.split("=");
			String dest = tmp[0];
			String localSrc= this.name;
			String messageToSendToController = dest+localSrc;
			
	
			byte[] data = null;
			DatagramPacket newPacket = null;
			data = messageToSendToController.getBytes();
			//send to controller at port 60000
			InetSocketAddress destAdr = new InetSocketAddress("local host", 60000);
			newPacket = new DatagramPacket(data, data.length, destAdr);
			try {
				socket.send(newPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	//waits for contact
		public void start() throws Exception {
			this.wait();
		}
		
		

}
