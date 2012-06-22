package org.alia4j.noirin.debug.data;

import java.util.Scanner;

public class DebugDataStoreInspector implements Runnable {

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String input = sc.next();
			if(input.equals("debugdata")) {
				print();
			} else if (input.equals("breakpoints")) {
				printBreakpoints();
			}
		}
	}
	
	private void print() {
		DebugDataStore.s().printList();
	}
	
	private void printBreakpoints() {
		ADBreakpointManager.instance().print();
	}
}
