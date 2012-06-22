package org.alia4j.noirin.debug.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.alia4j.noirin.debug.data.AddbCommandHandler;
import org.alia4j.noirin.debug.data.DebugDataStoreInspector;



public class AddbServerAgent implements Runnable {
	
	public static void main(String[] args) {
		new Thread(AddbServerAgent.instance()).start();
	} 
	
	private static AddbServerAgent agent;
	public static boolean DEBUG_MODE = false;
	public static boolean hasWaited = false;
	public static Object lock = new Object();;
	
	synchronized public static AddbServerAgent instance() {
		if(agent == null)
			agent = new AddbServerAgent();
		return agent;
	}
	
	private ServerSocket server;
	private Socket client;
	private DataInputStream in;
	private DataOutputStream out;
	private AddbPacketReceiveManager receiveManager;
	private AddbPacketSendManager sendManager;
	private AddbCommandHandler commandHandler;
	
	public int exampleHashCode;
	
	private AddbServerAgent() {}
	
	public void run() {
		try{
			server= new ServerSocket(5679);
			//while(true) {		
				client = server.accept();
//				System.out.println("Communication has been established.");
				
				in = new DataInputStream(client.getInputStream());
				out = new DataOutputStream(client.getOutputStream());
				
				receiveManager = new AddbPacketReceiveManager(client);
				new Thread(receiveManager).start();
				
				sendManager = new AddbPacketSendManager(client);
				new Thread(sendManager).start();
				
				commandHandler = new AddbCommandHandler();
				new Thread(commandHandler).start();
				
				new Thread(new DebugDataStoreInspector()).start();
								
			//}	
		} catch(Exception e) {
			e.printStackTrace();
		}
//		getPacketSendManager().sendEvent(AddbEvent.CONNECTION_ESTABLISHED);
	}
	
	public DataInputStream in() {
		return in;
	}
	
	public DataOutputStream out() {
		return out;
	}
	
	public AddbPacketReceiveManager getPacketReceiveManager() {
		return receiveManager;
	}
	
	public AddbPacketSendManager getPacketSendManager() {
		return sendManager;
	}
	
	public Socket getClient() {
		return this.client;
	}

	public void close() {
		
	}
}
