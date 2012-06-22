package org.alia4j.noirin.debug.data;

import java.util.Stack;

public class ADThread {
	private Stack<DispatchFrame> stack;
	
	ADThread() {
		stack = new Stack<DispatchFrame>();
	}
	
	public DispatchFrame popFrame() {
		return this.stack.pop();
	}
	
	public void pushFrame(DispatchFrame frame) {
		this.stack.push(frame);
	}
	
	public DispatchFrame peekFrame() {
		return this.stack.peek();
	}
	
	public DispatchFrame[] getFrames() {
		DispatchFrame[] frameArray = this.stack.toArray(new DispatchFrame[stack.size()]);
		DispatchFrame[] frames = new DispatchFrame[frameArray.length];
		for(int i=0; i<frameArray.length; i++) {
			frames[frames.length-1-i] = frameArray[i];
		}
		return frames;
	}
}
