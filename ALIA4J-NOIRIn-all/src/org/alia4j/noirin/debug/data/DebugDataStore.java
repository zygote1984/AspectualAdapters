package org.alia4j.noirin.debug.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.alia4j.addb.util.DataUtil;
import org.alia4j.liam.DebugInfo;

public class DebugDataStore {
	private static int id;
	private static DebugDataStore store;
	
	private String sourceRoot;
	private HashMap<Integer, ArrayList<DebugObject>> objectMap;
	private ArrayList<Object> debugObjectList;
	private Map<Object, DebugInfo> debugInfoMap;
	
	@SuppressWarnings("unused") //it is used by debug client, don't delete this field
	private DebugDataHelper helper = DebugDataHelper.getInstance();
	
	private ADThread thread;
	public ADThread getThread() {
		return this.thread;
	}
		
	private org.alia4j.fial.System system;
	public void setSystem(org.alia4j.fial.System system) {
		this.system = system;
	}
	public org.alia4j.fial.System getSystem() {
		return system;
	}
	
	public static DebugDataStore s() {
		if(store == null)
			store = new DebugDataStore();
		return store;
	}
	
	private DebugDataStore() {
		reset(); 
	}
	
	public void reset() {
		id = -1;
	  	objectMap = new HashMap<Integer, ArrayList<DebugObject>>();
	  	debugInfoMap = new HashMap<Object, DebugInfo>();
	  	debugObjectList = new ArrayList<Object>();
	  	thread = new ADThread();
	  	sourceRoot = null;
	}
	
	public String getSourceRoot() {
		return sourceRoot;
	}
	
	public void setSourceRoot(String source) {
		sourceRoot = source;
	}
	
	public Object get(int id) {
	    return this.debugObjectList.get(id);
	}
	
	public int put(Object obj) {
		if(obj == null)
			return -1;
		ArrayList<DebugObject> objs = objectMap.get(obj.hashCode());
		if(objs==null) {
		  objs = new ArrayList<DebugObject>();
		}
		for(int i=0; i<objs.size(); i++) {
		  if(objs.get(i).object() == obj) {
		    return objs.get(i).id();
		  }
		}
		id++;
		objs.add(new DebugObject(id, obj));
		this.objectMap.put(obj.hashCode(), objs);
		
		this.debugObjectList.add(obj);
		return id;
	}
	
	public int[] put(Object[] objs) {
		int ids[] = new int[objs.length];
		for(int i=0; i<ids.length; i++) {
			ids[i] = put(objs[i]);
		}
		return ids;
	}
	
	public Object getObject(byte[] data) {
		return get(DataUtil.bytesToInt(data, 0));
	}
	
	public Object getObject(int id) {
		return get(id);
	}
	
	public void putDebugInfo(Object obj, DebugInfo di) {
		if(di != DebugInfo.UNKNOWN_INFO) {
			this.debugInfoMap.put(obj, di);
		}
	}
	
	public DebugInfo debugInfo(Object obj) {
		return this.debugInfoMap.get(obj);
	}
	
	public void printList() {
		System.out.println("==============Debug Object List=================");
		for(int i=0; i<debugObjectList.size(); i++) {
			System.out.println(i + "\t" + debugObjectList.get(i).getClass());
			System.out.println("\t" + debugObjectList.get(i));
		}
	}
	
}
