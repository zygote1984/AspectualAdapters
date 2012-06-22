package org.alia4j.noirin.debug.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.alia4j.fial.AttachedAction;
import org.alia4j.fial.GenericFunction;
import org.alia4j.fial.ActionOrderElement;
import org.alia4j.noirin.CallContext;
import org.alia4j.noirin.DispatchFunctionEvaluator;

@SuppressWarnings("rawtypes")
public class DispatchFrame {
	private GenericFunction genericFunction;
	private CallContext callContext;
	private AttachedAction[] actionsToPerform;
	private DispatchFunctionEvaluator evaluator;
	private AttachedAction executingAction;
	
	public DispatchFrame(CallContext callContext, GenericFunction gf, 
			Set<AttachedAction> actionsToPerform, DispatchFunctionEvaluator evaluator) {
		this.callContext = callContext;
		this.genericFunction = gf;
		this.evaluator = evaluator;
		
		ActionOrderElement actions = org.alia4j.fial.System.getInstance().schedule(actionsToPerform);
		List<AttachedAction> actionList = new LinkedList<AttachedAction>();
		actionList.addAll(actions.getBefore());
		if(actions.getAround()!=null) {
			actionList.add(actions.getAround());
		}
		actionList.addAll(actions.getAfter());
		this.actionsToPerform = actionList.toArray(new AttachedAction[actionList.size()]);
	}
	
	public GenericFunction getGenericFunction() {
		return genericFunction;
	}
	public CallContext getCallContext() {
		return callContext;
	}

	public AttachedAction[] getActionsToPerform() {
		return actionsToPerform;
	}
	
	public DispatchFunctionEvaluator getEvaluator() {
		return evaluator;
	}
	
	public void setExecutingAction(AttachedAction aa) {
		executingAction = aa;
	}
	
	public AttachedAction getExecutingAction() {
		return executingAction;
	}
}
