package org.alia4j.noirin.debug.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.alia4j.fial.ActionOrderElement;
import org.alia4j.fial.AttachedAction;

public class DebugDataHelper {
	private static DebugDataHelper instance;
	public static DebugDataHelper getInstance() {
		if(instance == null) {
			instance = new DebugDataHelper();
		}
		return instance;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AttachedAction[] getOrderedActions(Set componentSet) {
		ActionOrderElement actions = org.alia4j.fial.System.getInstance().schedule(componentSet);
		List<AttachedAction> actionList = new LinkedList<AttachedAction>();
		actionList.addAll(actions.getBefore());
		if(actions.getAround()!=null) {
			actionList.add(actions.getAround());
		}
		actionList.addAll(actions.getAfter());
		AttachedAction[] acts = actionList.toArray(new AttachedAction[actionList.size()]);
		return acts;
	}
}
