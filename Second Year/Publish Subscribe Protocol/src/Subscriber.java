import java.awt.Point;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import tcdIO.*;

public class Subscriber extends Node {

	static boolean finished;//loop condition

	Terminal terminal;
	InetSocketAddress dstAddress;
	public int portNumber; // will be 70000 and up
	public static int startingPortNumber = 70000;

	Subscriber(Terminal terminal, String dstHost, int dstPort, int srcPort) {
		try {
			portNumber = srcPort;
			this.terminal = terminal;
			dstAddress = new InetSocketAddress(dstHost, dstPort);
			socket = new DatagramSocket(srcPort);

			listener.go();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	// string content data will be in form topic=message=serialnumber
	public synchronized void onReceipt(DatagramPacket packet) {
		StringContent content = new StringContent(packet);

		String tmp[] = content.toString().split("=");
		this.notify();
		terminal.println("Topic:" + tmp[0] + "\n Message:" + tmp[1]);
		//start prog again
		try {
			start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//sends messages to server
	public synchronized void start() throws Exception {

		byte[] data = null;
		DatagramPacket packet = null;
		terminal.println("Please enter a topic.");
		String string = terminal.readString();
		terminal.println(Integer.toString(portNumber));
		string += '=';
		data = (string + (terminal.readString("Do you wish to unsubscribe or subscribe? "))).getBytes();

		terminal.println("Sending packet...");
		packet = new DatagramPacket(data, data.length, dstAddress);
		socket.send(packet);
		terminal.println("Packet sent");
		this.wait();
	}

	//runs multiple subs
	public static void main(String[] args) {
		try {
			finished = false;
			double x = 0.0;
			double y = 32.0;
			int srcPort = 0;
			String newLine;
			
			while (!finished) {
				//checking if still want more subs
				System.out.println("Would you like another subscriber?[Y/N]");
				Scanner sc = new Scanner(System.in);
				 newLine = sc.nextLine();
				if (newLine.equals("Y")) {
					// setting up terminal in new location
					Terminal terminal = new Terminal("Subscriber");
					Point loc = new Point((int) x, (int) y);
					terminal.setLocation(loc);
					if (x % 900 == 0 && x / 900 != 0) {
						x = 0;
						y += 200;
					} else
						x += 300;

					srcPort = terminal
							.readInt("Please enter a port number over 70000" + "\n" + " or enter a zero to close: ");
					if (srcPort > 70000)
						(new Subscriber(terminal, "localhost", 60000, srcPort)).start();
					else {
						terminal.println("Closing Window. Goodbye.");
						
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