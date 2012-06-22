package org.alia4j.noirin.debug.data;

import java.util.Set;

import org.alia4j.addb.util.AddbCommand;
import org.alia4j.addb.util.DataUtil;
import org.alia4j.bdd.vertex.Sink;
import org.alia4j.bdd.vertex.Split;
import org.alia4j.fial.AttachedAction;
import org.alia4j.fial.GenericFunction;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.AndPredicate;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.BasicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.DebugInfo;
import org.alia4j.liam.OrPredicate;
import org.alia4j.liam.Predicate;
import org.alia4j.liam.Specialization;
import org.alia4j.liam.action.FieldAction;
import org.alia4j.liam.action.MemberAction;
import org.alia4j.liam.action.MethodCallAction;
import org.alia4j.liam.pattern.MethodPattern;
import org.alia4j.liam.predicate.InstanceofPredicate;
import org.alia4j.liam.signature.ConstructorSignature;
import org.alia4j.liam.signature.FieldSignature;
import org.alia4j.liam.signature.MethodSignature;
import org.alia4j.liam.signature.Signature;
import org.alia4j.noirin.debug.connection.AddbCommandPacket;
import org.alia4j.noirin.debug.connection.AddbReplyPacket;
import org.alia4j.noirin.debug.connection.AddbServerAgent;

public class AddbCommandHandler implements Runnable {
	
	@Override
	public void run() {
		try {
			while(true) {
				AddbCommandPacket packet = AddbServerAgent.instance().getPacketReceiveManager().getCommand();
				byte [] data = replyData(packet);
				AddbReplyPacket rp = new AddbReplyPacket();
				rp.setId(packet.getId());
				rp.setData(data);
				AddbServerAgent.instance().getPacketSendManager().sendPacket(rp);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	protected byte[] replyData(AddbCommandPacket packet) {
		byte[] rcvData = packet.getData();
		switch(packet.getCommand()) {
		  
		  case AddbCommand.TERMINATE : return Handle_TERMINATE(rcvData);
		  case AddbCommand.BREAKPOINT_ADD : return Handle_BREAKPOINT_ADD(rcvData);
		  case AddbCommand.BREAKPOINT_REMOVE : return Handle_BREAKPOINT_REMOVE(rcvData);
		  case AddbCommand.BREAKPOINT_CHECK : return Handle_BREAKPOINT_CHECK(rcvData);
		  case AddbCommand.BREAKPOINT_UNCHECK : return Handle_BREAKPOINT_UNCHECK(rcvData);
		  
		  case AddbCommand.DEPLOYED_ATTACHMENTS : return Handle_DEPLOYED_ATTACHMENTS(rcvData);
		  case AddbCommand.SOURCE_STRING : return Handle_SOURCE_STRING(rcvData);
		  case AddbCommand.DEBUG_INFO : return Handle_DEBUG_INFO(rcvData); 
		  case AddbCommand.THREAD_FRAMES : return Handle_THREAD_FRAMES(rcvData);
		  case AddbCommand.CONTINUE_EXECUTION : return Handle_CONTINUE_EXECUTION();
		  
		  case AddbCommand.DF_FUNCTION : return Handle_DF_FUNCTION(rcvData);
		  case AddbCommand.DF_CALL_CONTEXT : return Handle_DF_CALL_CONTEXT(rcvData);
		  case AddbCommand.DF_ACTIONS : return Handle_DF_ACTIONS(rcvData);
		  case AddbCommand.DF_EXE_ACT : return Handle_DF_EXE_ACT(rcvData);
		  
		  case AddbCommand.GF_STRATEGY : return Handle_GF_STRATEGY(rcvData);
		  case AddbCommand.GF_SIGNATURE : return Handle_GF_SIGNATURE(rcvData);
		  
		  case AddbCommand.SPLIT_VARIABLE : return Handle_SPLIT_VARIABLE(rcvData);
		  case AddbCommand.SPLIT_HIGH : return Handle_SPLIT_HIGH(rcvData);
		  case AddbCommand.SPLIT_LOW : return Handle_SPLIT_LOW(rcvData);
		  
		  case AddbCommand.SINK_ATTACTS : return Handle_SINK_ATTACTS(rcvData);
		  case AddbCommand.SINK_ISCOMPLEMENTED : return Handle_SINK_ISCOMPLEMENTED(rcvData);
		  
		  case AddbCommand.ATTA_SCHED_INFO : return Handle_ATTA_SCHED_INFO(rcvData);
		  case AddbCommand.ATTA_ACTION : return Handle_ATTA_ACTION(rcvData);
		  case AddbCommand.ATTA_SPECS : return Handle_ATTA_SPECS(rcvData);
		  case AddbCommand.ATTA_DEPLOY : return Handle_ATTA_DEPLOY(rcvData);
		  case AddbCommand.ATTA_UNDEPLOY : return Handle_ATTA_UNDEPLOY(rcvData);
		  
		  case AddbCommand.SPEC_PATTERN : return Handle_SPEC_PATTERN(rcvData);
		  case AddbCommand.SPEC_PREDICATE : return Handle_SPEC_PREDICATE(rcvData);
		  case AddbCommand.SPEC_CONTEXTS : return Handle_SPEC_CONTEXTS(rcvData);
		  
		  case AddbCommand.CTX_VALUE : return Handle_CTX_VALUE(rcvData);
		  case AddbCommand.CTX_TYPE : return Handle_CTX_TYPE(rcvData);
		  	
		  case AddbCommand.ATOMPRED_HAS_EVAL : return Handle_ATOMPRED_HAS_EVAL(rcvData);
		  case AddbCommand.ATOMPRED_EVAL_RESULT : return Handle_ATOMPRED_EVAL_RESULT(rcvData);
		  
		  case AddbCommand.TYPEDES_NORMALNAME : break;
		  
		  case AddbCommand.MCA_PARA_TYPES : return Handle_MCA_PARA_TYPES(rcvData);
		  case AddbCommand.MCA_RESULT_TYPE : return Handle_MCA_RESULT_TYPE(rcvData);
		  case AddbCommand.MCA_CALL_TYPE : break;
		  
		  case AddbCommand.BOOLPRED_SUCCEEDS : break;
		  
		  case AddbCommand.INSPRED_REQTYPE : return Handle_INSPRED_REQTYPE(rcvData);
		  case AddbCommand.INSPRED_CTX : return Handle_INSPRED_CTX(rcvData);
		  
		  case AddbCommand.SIG_MODIFIERS : break;
		  case AddbCommand.SIG_DECL_CLS : return Handle_SIG_DECL_CLS(rcvData);
		  case AddbCommand.SIG_NAME : break;
		  case AddbCommand.SIG_RTN_TYPE : return Handle_SIG_RTN_TYPE(rcvData);
		  
		  case AddbCommand.METSIG_PARA_TYPES : return Handle_METSIG_PARA_TYPES(rcvData);
		  case AddbCommand.METSIG_EXCP_TYPES : return Handle_METSIG_EXCP_TYPES(rcvData);
		  
		  case AddbCommand.CONSIG_PARA_TYPES : return Handle_CONSIG_PARA_TYPES(rcvData);
		  case AddbCommand.CONSIG_EXCP_TYPES : return Handle_CONSIG_EXCP_TYPES(rcvData);
		  
		  case AddbCommand.FSIG_TYPE : return Handle_FSIG_TYPE(rcvData);
		  case AddbCommand.FSIG_ISREAD : break;
		  
		  case AddbCommand.MP_MODI_PTN : return Handle_MP_MODI_PTN(rcvData);
		  case AddbCommand.MP_TYPE_PTN : return Handle_MP_TYPE_PTN(rcvData);
		  case AddbCommand.MP_CLS_PTN : return Handle_MP_CLS_PTN(rcvData);
		  case AddbCommand.MP_NAME_PTN : return Handle_MP_NAME_PTN(rcvData);
		  case AddbCommand.MP_PARA_PTN : return Handle_MP_PARA_PTN(rcvData);
		  case AddbCommand.MP_EXCP_PTN : return Handle_MP_EXCP_PTN(rcvData);
		  
		  case AddbCommand.BIPRED_LEFT : return Handle_BIPRED_LEFT(rcvData);
		  case AddbCommand.BIPRED_RIGHT : return Handle_BIPRED_RIGHT(rcvData);
		  
		  case AddbCommand.BSCP_POSITIVE : break;
		  case AddbCommand.BSCP_ATOM : return Handle_BSCP_ATOM(rcvData);
		  
		  case AddbCommand.MA_CLS : return Handle_MA_CLS(rcvData);
		  case AddbCommand.MA_NAME : break;
		  
		  case AddbCommand.ATTACT_ACTION : return Handle_ATTACT_ACTION(rcvData);
		  case AddbCommand.ATTACT_SCHED_INFO : return Handle_ATTACT_SCHED_INFO(rcvData);
		  case AddbCommand.ATTACT_CTXS : return Handle_ATTACT_CTXS(rcvData);
		  
		  case AddbCommand.FDACT_TYPE : return Handle_FDACT_TYPE(rcvData);
		}
		System.err.println("This command is not expected : " + AddbCommand.commandName(packet.getCommand()));
		return null;
	}

	private byte[] Handle_TERMINATE(byte[] rcvData) {
		System.out.println("Close");
		AddbServerAgent.instance().close();
		return null;
	}

	private byte[] Handle_BREAKPOINT_UNCHECK(byte[] rcvData) {
		int id = DataUtil.bytesToInt(rcvData, 0);
		ADBreakpointManager.instance().uncheckBreakpoint(id);
		return null;
	}

	private byte[] Handle_BREAKPOINT_CHECK(byte[] rcvData) {
		int id = DataUtil.bytesToInt(rcvData, 0);
		ADBreakpointManager.instance().checkBreakpoint(id);
		return null;
	}

	private byte[] Handle_BREAKPOINT_REMOVE(byte[] rcvData) {
		int id = DataUtil.bytesToInt(rcvData, 0);
		ADBreakpointManager.instance().removeBreakpoint(id);
		return null;
	}

	private byte[] Handle_BREAKPOINT_ADD(byte[] rcvData) {
		int lineNumber = DataUtil.bytesToInt(rcvData, 0);
		byte[] strBytes = new byte[rcvData.length - 4];
		java.lang.System.arraycopy(rcvData, 4, strBytes, 0, strBytes.length);
		String fileName = DataUtil.bytesToString(strBytes);
		ADBreakpoint bp = new ADBreakpoint(fileName, lineNumber);
		int id = ADBreakpointManager.instance().addBreakpoint(bp);
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_SOURCE_STRING(byte[] rcvData) {
		Object obj = DebugDataStore.s().getObject(rcvData);
		DebugInfo di = DebugDataStore.s().debugInfo(obj);
		return DataUtil.stringToBytes(di.getSourceString());
	}

	private byte[] Handle_DEPLOYED_ATTACHMENTS(byte[] rcvData) {
		org.alia4j.fial.System system = DebugDataStore.s().getSystem();
		Attachment[] attachments = system.deployedAttachments();
		int[] ids = DebugDataStore.s().put(attachments);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(attachments.length),
				DataUtil.intsToBytes(ids));
	}

	private byte[] Handle_FDACT_TYPE(byte[] rcvData) {
		FieldAction fa = (FieldAction) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(fa.getFieldTypeName());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_DEBUG_INFO(byte[] rcvData) {
		Object obj = DebugDataStore.s().getObject(rcvData);
		DebugInfo di = DebugDataStore.s().debugInfo(obj);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(di.getFirstLineNumber()),
				DataUtil.intToBytes(di.getLastLineNumber()),
				DataUtil.stringToBytes(di.getFileName()));
	}

	private byte[] Handle_CONTINUE_EXECUTION() {
		AddbServerAgent.hasWaited = true;
		synchronized(AddbServerAgent.lock) {
			AddbServerAgent.lock.notifyAll();
		}
		return null;
	}

	private byte[] Handle_ATTACT_CTXS(byte[] rcvData) {
		AttachedAction act = (AttachedAction) DebugDataStore.s().getObject(rcvData);
		Context[] ctxs = act.getContextArray();
		int[] ids = DebugDataStore.s().put(ctxs);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(ctxs.length),
				DataUtil.intsToBytes(ids));
	}

	private byte[] Handle_ATTACT_SCHED_INFO(byte[] rcvData) {
		AttachedAction act = (AttachedAction) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(act.getScheduleInfo());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_ATTACT_ACTION(byte[] rcvData) {
		AttachedAction act = (AttachedAction) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(act.getAction());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_MA_CLS(byte[] rcvData) {
		MemberAction memAct = (MemberAction) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(memAct.getDeclaringClassName());
		return DataUtil.intToBytes(id);
	}

	@SuppressWarnings("rawtypes")
	private byte[] Handle_BSCP_ATOM(byte[] rcvData) {
		BasicPredicate pred = (BasicPredicate) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(pred.getAtomicPredicate());
		return DataUtil.intToBytes(id);
	}

	@SuppressWarnings("rawtypes")
	private byte[] Handle_BIPRED_RIGHT(byte[] rcvData) {
		Object obj = DebugDataStore.s().getObject(rcvData);
		Predicate pred = null;
		if(obj instanceof AndPredicate) {
			AndPredicate andp = (AndPredicate) obj;
			pred = andp.getRightHandSide();
		} else if(obj instanceof OrPredicate) {
			OrPredicate orp = (OrPredicate) obj;
			pred = orp.getRightHandSide();
		}
		int id = DebugDataStore.s().put(pred);
		return DataUtil.intToBytes(id);
	}

	@SuppressWarnings("rawtypes")
	private byte[] Handle_BIPRED_LEFT(byte[] rcvData) {
		Object obj = DebugDataStore.s().getObject(rcvData);
		Predicate pred = null;
		if(obj instanceof AndPredicate) {
			AndPredicate andp = (AndPredicate) obj;
			pred = andp.getLeftHandSide();
		} else if(obj instanceof OrPredicate) {
			OrPredicate orp = (OrPredicate) obj;
			pred = orp.getLeftHandSide();
		}
		int id = DebugDataStore.s().put(pred);
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_MP_EXCP_PTN(byte[] rcvData) {
		MethodPattern ptn = (MethodPattern) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(ptn.getExceptionsPattern());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_MP_PARA_PTN(byte[] rcvData) {
		MethodPattern ptn = (MethodPattern) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(ptn.getParametersPattern());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_MP_NAME_PTN(byte[] rcvData) {
		MethodPattern ptn = (MethodPattern) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(ptn.getNamePattern());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_MP_CLS_PTN(byte[] rcvData) {
		MethodPattern ptn = (MethodPattern) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(ptn.getDeclaringClassPattern());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_MP_TYPE_PTN(byte[] rcvData) {
		MethodPattern ptn = (MethodPattern) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(ptn.getReturnTypePattern());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_MP_MODI_PTN(byte[] rcvData) {
		MethodPattern ptn = (MethodPattern) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(ptn.getModifiersPattern());
		return DataUtil.intToBytes(id);
	}
	
	private byte[] Handle_FSIG_TYPE(byte[] rcvData) {
		FieldSignature sig = (FieldSignature) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(sig.getType());
		return DataUtil.intToBytes(id);
	}
	
	private byte[] Handle_METSIG_EXCP_TYPES(byte[] rcvData) {
		MethodSignature ms = (MethodSignature) DebugDataStore.s().getObject(rcvData);
		TypeDescriptor[] types = ms.getExceptionTypes();
		int[] ids = DebugDataStore.s().put(types);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(types.length),
				DataUtil.intsToBytes(ids));
	}
	
	private byte[] Handle_METSIG_PARA_TYPES(byte[] rcvData) {
		MethodSignature ms = (MethodSignature) DebugDataStore.s().getObject(rcvData);
		TypeDescriptor[] types = ms.getParameterTypes();
		int[] ids = DebugDataStore.s().put(types);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(types.length),
				DataUtil.intsToBytes(ids));
	}
	
	private byte[] Handle_CONSIG_EXCP_TYPES(byte[] rcvData) {
		ConstructorSignature cs = (ConstructorSignature) DebugDataStore.s().getObject(rcvData);
		TypeDescriptor[] types = cs.getExceptionTypes();
		int[] ids = DebugDataStore.s().put(types);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(types.length),
				DataUtil.intsToBytes(ids));
	}

	private byte[] Handle_CONSIG_PARA_TYPES(byte[] rcvData) {
		ConstructorSignature cs = (ConstructorSignature) DebugDataStore.s().getObject(rcvData);
		TypeDescriptor[] types = cs.getParameterTypes();
		int[] ids = DebugDataStore.s().put(types);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(types.length),
				DataUtil.intsToBytes(ids));
	}
	
	private byte[] Handle_SIG_RTN_TYPE(byte[] rcvData) {
		Signature sig = (Signature) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(sig.getReturnType());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_SIG_DECL_CLS(byte[] rcvData) {
		Signature sig = (Signature) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(sig.getDeclaringClass());
		return DataUtil.intToBytes(id);
	}
	
	private byte[] Handle_INSPRED_CTX(byte[] rcvData) {
		InstanceofPredicate pred = (InstanceofPredicate) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(pred.getContexts().get(0));
		return DataUtil.intToBytes(id);
	}
	
	private byte[] Handle_INSPRED_REQTYPE(byte[] rcvData) {
		InstanceofPredicate pred = (InstanceofPredicate) DebugDataStore.s().getObject(rcvData);
		//TODO: why pred.getRequiredTypeName() is not working?
		//TypeDescriptor td = pred.getRequiredTypeName();
//		System.out.println("got type : " + td);
//		int id = DebugDataStore.s().put(pred.getRequiredTypeName());
		return DataUtil.intToBytes(0);
	}

	private byte[] Handle_MCA_RESULT_TYPE(byte[] rcvData) {
		MethodCallAction mca = (MethodCallAction) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(mca.getResultType());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_MCA_PARA_TYPES(byte[] rcvData) {
		MethodCallAction mca = (MethodCallAction) DebugDataStore.s().getObject(rcvData);
		TypeDescriptor[] types = mca.getParameterTypeNames();
		int[] ids = DebugDataStore.s().put(types);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(types.length),
				DataUtil.intsToBytes(ids));
	}

	private byte[] Handle_ATOMPRED_EVAL_RESULT(byte[] rcvData) {
		int frameId = DataUtil.bytesToInt(rcvData, 0);
		DispatchFrame frame = (DispatchFrame) DebugDataStore.s().getObject(frameId);
		int apId = DataUtil.bytesToInt(rcvData, 4);
		AtomicPredicate ap = (AtomicPredicate) DebugDataStore.s().getObject(apId);
		Boolean result = frame.getEvaluator().getEvaluationResult(ap);
		int resultInt;
		if(result == null) {
			resultInt = 2;
		} else if(result.booleanValue() == true) {
			resultInt = 1;
		} else {
			resultInt = 0;
		}
		return DataUtil.intToBytes(resultInt);
	}

	private byte[] Handle_ATOMPRED_HAS_EVAL(byte[] rcvData) {
		// TODO Auto-generated method stub
		return null;
	}

	private byte[] Handle_CTX_TYPE(byte[] rcvData) {
		// TODO Auto-generated method stub
		return null;
	}

	private byte[] Handle_CTX_VALUE(byte[] rcvData) {
		// TODO Auto-generated method stub
		return null;
	}

	private byte[] Handle_SPEC_CONTEXTS(byte[] rcvData) {
		Specialization spec = (Specialization) DebugDataStore.s().getObject(rcvData);
		Context[] ctxs = spec.getContextArray();
		int[] ids = DebugDataStore.s().put(ctxs);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(ctxs.length),
				DataUtil.intsToBytes(ids));
	}

	private byte[] Handle_SPEC_PREDICATE(byte[] rcvData) {
		Specialization spec = (Specialization) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(spec.getPredicate());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_SPEC_PATTERN(byte[] rcvData) {
		Specialization spec = (Specialization) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(spec.getPattern());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_ATTA_SPECS(byte[] rcvData) {
		Attachment atta = (Attachment) DebugDataStore.s().getObject(rcvData);
		Specialization[] specs = atta.getSpecializationArray();
		int[] ids = DebugDataStore.s().put(specs);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(specs.length),
				DataUtil.intsToBytes(ids));
	}

	private byte[] Handle_ATTA_ACTION(byte[] rcvData) {
		Attachment atta = (Attachment) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(atta.getAction());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_ATTA_SCHED_INFO(byte[] rcvData) {
		Attachment atta = (Attachment) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(atta.getScheduleInfo());
		return DataUtil.intToBytes(id);
	}
	
	@SuppressWarnings("static-access")
	private byte[] Handle_ATTA_DEPLOY(byte[] rcvData) {
		Attachment atta = (Attachment) DebugDataStore.s().getObject(rcvData);
		DebugDataStore.s().getSystem().deploy(atta);
		return DataUtil.intToBytes(0);
	}

	@SuppressWarnings("static-access")
	private byte[] Handle_ATTA_UNDEPLOY(byte[] rcvData) {
		Attachment atta = (Attachment) DebugDataStore.s().getObject(rcvData);
		DebugDataStore.s().getSystem().undeploy(atta);
		return DataUtil.intToBytes(0);
	}
	
	private byte[] Handle_SINK_ISCOMPLEMENTED(byte[] rcvData) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	private byte[] Handle_SINK_ATTACTS(byte[] rcvData) {
		Sink sink = (Sink) DebugDataStore.s().getObject(rcvData);
		Set componentSet = sink.getValue().getComponents();
		AttachedAction[] acts = DebugDataHelper.getInstance().getOrderedActions(componentSet);
		
		int[] ids = DebugDataStore.s().put(acts);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(acts.length),
				DataUtil.intsToBytes(ids));
	}

	@SuppressWarnings("rawtypes")
	private byte[] Handle_SPLIT_LOW(byte[] rcvData) {
		Split split = (Split) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(split.getLow());
		return DataUtil.intToBytes(id);
	}

	@SuppressWarnings("rawtypes")
	private byte[] Handle_SPLIT_HIGH(byte[] rcvData) {
		Split split = (Split) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(split.getHigh());
		return DataUtil.intToBytes(id);
	}

	@SuppressWarnings("rawtypes")
	private byte[] Handle_SPLIT_VARIABLE(byte[] rcvData) {
		Split split = (Split) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(split.getVariable());
		return DataUtil.intToBytes(id);
	}

	@SuppressWarnings("rawtypes")
	private byte[] Handle_GF_SIGNATURE(byte[] rcvData) {
		GenericFunction gf = (GenericFunction) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(gf.getSignature());
		return DataUtil.intToBytes(id);
	}

	@SuppressWarnings("rawtypes")
	private byte[] Handle_GF_STRATEGY(byte[] rcvData) {
		GenericFunction gf = (GenericFunction) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(gf.getDispatchStrategy());
		return DataUtil.intToBytes(id);
	}
	
	private byte[] Handle_DF_EXE_ACT(byte[] rcvData) {
		DispatchFrame df = (DispatchFrame) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(df.getExecutingAction());
		return DataUtil.intToBytes(id);
	}
	
	private byte[] Handle_DF_ACTIONS(byte[] rcvData) {
		DispatchFrame df = (DispatchFrame) DebugDataStore.s().getObject(rcvData);
		AttachedAction[] acts = df.getActionsToPerform();
		int[] ids = DebugDataStore.s().put(acts);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(acts.length),
				DataUtil.intsToBytes(ids));
	}

	private byte[] Handle_DF_CALL_CONTEXT(byte[] rcvData) {
		DispatchFrame df = (DispatchFrame) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(df.getCallContext());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_DF_FUNCTION(byte[] rcvData) {
		DispatchFrame df = (DispatchFrame) DebugDataStore.s().getObject(rcvData);
		int id = DebugDataStore.s().put(df.getGenericFunction());
		return DataUtil.intToBytes(id);
	}

	private byte[] Handle_THREAD_FRAMES(byte[] rcvData) {
		ADThread thread = DebugDataStore.s().getThread();
		DispatchFrame[] frames = thread.getFrames();
		int[] ids = DebugDataStore.s().put(frames);
		return DataUtil.concatBytes(
				DataUtil.intToBytes(frames.length),
				DataUtil.intsToBytes(ids));
	}
}
