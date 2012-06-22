package org.alia4j.noirin.debug.connection;

import java.net.Socket;
import java.util.LinkedList;

import org.alia4j.addb.util.DataUtil;

public class AddbPacketSendManager extends AddbPacketManager {
	
	private LinkedList<AddbReplyPacket> fOutgoingPackets;
	
	AddbPacketSendManager(Socket socket) {
		super(socket);
		this.fOutgoingPackets = new LinkedList<AddbReplyPacket>();
	}

	@Override
	public void run() {
		try {
			while(isConnected()) {
				sendAvailablePackets();
			}
		} catch (Exception e) {
			e.printStackTrace();
			disconnect();
		}	
	}
	
	public void sendEvent(int event) {
		AddbReplyPacket pkt = new AddbReplyPacket();
		pkt.setEvent();
		pkt.setData(DataUtil.intToBytes(event));
		try {
			sendPacket(pkt);
//			System.out.println(pkt.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendPacket(AddbReplyPacket packet) throws Exception {
		if(!isConnected()) {
			throw new Exception("Socket has been closed.");
		}
		synchronized(fOutgoingPackets) {
			fOutgoingPackets.add(packet);
			fOutgoingPackets.notifyAll();
		}
	}
	
	private void sendAvailablePackets() throws Exception {
		LinkedList<AddbReplyPacket> packetsToSend = new LinkedList<AddbReplyPacket>();
	    synchronized (fOutgoingPackets) {
			while (fOutgoingPackets.size() == 0) {
				fOutgoingPackets.wait();
			}
			packetsToSend.addAll(fOutgoingPackets);
			fOutgoingPackets.clear();
        }

		// Put available packets on Output Stream.
		while (packetsToSend.size() > 0) {
			AddbReplyPacket packet = packetsToSend.removeFirst();	
//			System.out.println("Send packet : " + packet);
			byte[] bytes = packet.getPacketAsBytes();
			this.writePacket(bytes);
		}
	}
}
