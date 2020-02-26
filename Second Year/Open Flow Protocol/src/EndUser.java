import java.net.DatagramPacket;
import java.net.DatagramSocket;

import tcdIO.Terminal;

public class EndUser extends Node{
	
	Terminal terminal;
	final int PORT_NUMBER1 = 50000;
	final int PORT_NUMBER2 = 50001;
	String name;
	
	EndUser(Terminal terminal, int port, String name){
		try {
			this.terminal=terminal;
			socket= new DatagramSocket(port);
			this.name=name;
			listener.go();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	//prints message to terminal
	public void onReceipt(DatagramPacket packet) {
		StringContent content = new StringContent(packet);
		String messageToPrint = content.toString();
		this.notify();
		terminal.println("Message: " + messageToPrint);
		//start prog again
		try {
			start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//sends messages to first router
		public void start() throws Exception {
			String message;
			int nextRouter;
			if(this.name.equals("e1")) {
				message="e2=";
				nextRouter=50000; //router 1
				
			}
			else {
				message="e1=";
				nextRouter=50002;//router3
			}
			 message += terminal.readString("Please enter a message:");
			
			
			// packet stuff
			byte[] data = null;
			DatagramPacket packet = null;
			data = message.getBytes();
			terminal.println("Sending packet...");
			
			packet = new DatagramPacket(data, data.length, nextRouter);

			// sending packet
			socket.send(packet);
			terminal.println("Packet sent");
			this.wait();
		}
		
		public void main() {
			try {
				
				Terminal e1Terminal=new Terminal("User1");
				Terminal e2Terminal = new Terminal ("User2");
				e1Terminal.println("Hello!");
				e2Terminal.println("Hello!");
				
				EndUser e1=new EndUser(e1Terminal, PORT_NUMBER1, "e1");
				EndUser e2=new EndUser(e2Terminal, PORT_NUMBER2, "e2");
				e1.start();
				e2.start();
			
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
}
