import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import tcdIO.Terminal;

public class Controller extends Node {

	Terminal terminal;
	TableEntry flowTable[];
	Router routers[];
	final int PORT_NUMBER = 60000;

	Controller(Terminal terminal, int port) {
		try {
			this.terminal=terminal;
			socket = new DatagramSocket(port);
			listener.go();
			flowTable = new TableEntry [6];
			flowTable = configureFlowTable();
			routers= new Router[3];
			configureRouters();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public TableEntry[] configureFlowTable() {
		// flow for sending from e1 to e2
		TableEntry tb1 = new TableEntry("r1", "e2", "e1", "r3");
		TableEntry tb2 = new TableEntry("r2", "e2", "r1", "r3");
		TableEntry tb3 = new TableEntry("r3", "e2", "r1", "e2");
		// add to array
		flowTable[0] = tb1;
		flowTable[1] = tb2;
		flowTable[2] = tb3;

		// flow for sending from e2 to e1
		TableEntry tb4 = new TableEntry("r3", "e1", "e2", "r1");
		TableEntry tb5 = new TableEntry("r2", "e1", "r3", "r1");
		TableEntry tb6 = new TableEntry("r1", "e1", "r3", "e1");
		// add to array

		flowTable[3] = tb4;
		flowTable[4] = tb5;
		flowTable[5] = tb6;
		return flowTable;

	}
	
	public void configureRouters() {
		//make routers
		Router r1= new Router(70000, "r1");
		Router r2= new Router(70001, "r2");
		Router r3= new Router(70002, "r3");
		routers[0]=r1;
		routers[1]=r2;
		routers[2]=r3;
		
	}

	@Override
	public void onReceipt(DatagramPacket packet) {
		//sorting message into bits of info
		StringContent content = new StringContent(packet);
		String fullMessage = content.toString();
		String tmp[] = content.toString().split("=");
		terminal.println(fullMessage);
		
		String dest = tmp[0];
		String localSrc= tmp[1];
		
		//find table entry
		TableEntry toSend =null;
		for (int i=0; i<flowTable.length; i++) {
			if(flowTable[i].localSrc.equals(localSrc) && flowTable[i].destination.equals(dest)) {
				toSend = flowTable[i];
			}
		}
		//sending info back to router just nextdst 
		byte[] data = null;
		DatagramPacket newPacket = null;
		data = toSend.localDst.getBytes();//just sending back next router vdest 
		
		int portNumber = packet.getPort(); // get Router port number
		InetSocketAddress destAdr = new InetSocketAddress("local host", portNumber);
		newPacket = new DatagramPacket(data, data.length, destAdr);
		try {
			socket.send(newPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//waits for contact
	public void start() throws Exception {
		terminal.print("Waiting for contact");
		this.wait();
	}
	
	public void main() {
		try {
			
			
			//make controller
			Terminal terminal = new Terminal("Controller");
			Controller controller = new Controller(terminal, PORT_NUMBER);
			
			//start routers 
			for(int i=0; i<controller.routers.length; i++) {
				controller.routers[i].start();
			}
			//start controller
			controller.start();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
