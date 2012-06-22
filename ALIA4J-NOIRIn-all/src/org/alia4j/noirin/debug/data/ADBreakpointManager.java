package org.alia4j.noirin.debug.data;

import java.util.LinkedList;
import java.util.List;

import org.alia4j.noirin.CallContext;

public class ADBreakpointManager {
	private static ADBreakpointManager instance;
	public static ADBreakpointManager instance() {
		if(instance == null) {
			instance = new ADBreakpointManager();
		}
		return instance;
	}
	
	private List<ADBreakpoint> historyBreakpointList;
	private List<ADBreakpoint> activeBreakpointList;
	
	private ADBreakpointManager() {
		this.historyBreakpointList = new LinkedList<ADBreakpoint>();
		this.activeBreakpointList = new LinkedList<ADBreakpoint>();
	}

	public int addBreakpoint(ADBreakpoint bp) {
		if(!historyBreakpointList.contains(bp)) {
			historyBreakpointList.add(bp);
		}
		int id = historyBreakpointList.indexOf(bp);
		bp.setId(id);
		ADBreakpoint adbp = historyBreakpointList.get(id);
		adbp.check();
		this.activeBreakpointList.add(adbp);
		return id;
	}
	
	public void removeBreakpoint(int id) {
		ADBreakpoint bp = historyBreakpointList.get(id);
		activeBreakpointList.remove(bp);
	}
	
	public void checkBreakpoint(int id) {
		ADBreakpoint bp = historyBreakpointList.get(id);
		bp.check();
	}
	
	public void uncheckBreakpoint(int id) {
		ADBreakpoint bp = historyBreakpointList.get(id);
		bp.uncheck();
	}

	public void print() {
		for(ADBreakpoint bp : activeBreakpointList) {
			System.out.println(bp.getId() + " " + bp.getFileName() + 
					" " + bp.getLineNumber() + " " + bp.isChecked());
		}
	}

	public boolean matched(CallContext callContext) {
		for(ADBreakpoint bp : activeBreakpointList) {
			if(bp.isChecked()) {
				if(callContext.callerFileName.equals(bp.getFileName()) &&
						callContext.callLineNumber == bp.getLineNumber())
					return true;
			}
		}
		return false;
	}
}
