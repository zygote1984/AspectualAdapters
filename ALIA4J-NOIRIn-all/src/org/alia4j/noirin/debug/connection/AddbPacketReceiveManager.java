package org.alia4j.noirin.debug.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.ListIterator;

public class AddbPacketReceiveManager extends AddbPacketManager {
    
	private LinkedList<AddbCommandPacket> fAddbCommandPackets;
	
	AddbPacketReceiveManager(Socket socket) {
		super(socket);
        fAddbCommandPackets = new LinkedList<AddbCommandPacket>();
	}

	public void disconnect() {
		super.disconnect();
		synchronized (fAddbCommandPackets) {
            fAddbCommandPackets.notifyAll();
        }
	}
	
	@Override
	public void run() {
		try{
			while(isConnected()) {
				readAvailablePacket();
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.disconnect();
		}
	}
	
	private void readAvailablePacket() throws IOException {
        byte[] bytes = this.readPacket();
        AddbPacket packet = AddbPacket.build(bytes);
//        System.out.println("Receive packet : " + packet);
        if(packet instanceof AddbCommandPacket) {
        	AddbCommandPacket rp = (AddbCommandPacket)packet;
        	addAddbCommandPacket(rp);
        }
    }
	
	private void addAddbCommandPacket(AddbCommandPacket packet) {
        synchronized (fAddbCommandPackets) {
            fAddbCommandPackets.add(packet);
            fAddbCommandPackets.notifyAll();
        }
    }
	
	private AddbCommandPacket removeAddbCommandPacket() {
		 ListIterator<AddbCommandPacket> iter = fAddbCommandPackets.listIterator();
	        while (iter.hasNext()) {
	        	AddbCommandPacket packet = iter.next();
	        	iter.remove();
	        	return packet;
	     }
	     return null;
    }
	
	
	public AddbCommandPacket getCommand() throws Exception {
		AddbCommandPacket packet = null;
        synchronized (fAddbCommandPackets) {
            while (isConnected()) {
                packet = removeAddbCommandPacket();
                if (packet != null) {
                    break;
                }
                fAddbCommandPackets.wait();
            }
        }
        if (packet == null) {
            synchronized (fAddbCommandPackets) {
                packet = removeAddbCommandPacket();
            }
        }
        if (!isConnected())
            throw new Exception("Socket has been closed."); 
        return packet;
    }
	
}
