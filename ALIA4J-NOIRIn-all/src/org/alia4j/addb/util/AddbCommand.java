package org.alia4j.addb.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class AddbCommand {
	  public static final int ADMIRROR = 1;
	  public static final int DISPATCH_FRAME = 2;
	  public static final int GENERIC_FUNCTION = 3;
	  public static final int VERTEX = 4;
	  public static final int SPLIT = 5;
	  public static final int SINK = 6;
	  public static final int ATTACHMENT = 7;
	  public static final int SCHEDULE_INFO = 8;
	  public static final int ACTION = 9;
	  public static final int SPECIALIZATION = 10;
	  public static final int CONTEXT = 14;
	  public static final int ATOMIC_PREDICATE = 15;
	  public static final int TYPE_DESCRIPTOR = 16;
	  public static final int METHOD_CALL_ACTION = 17;
	  public static final int BOOLEAN_PREDICATE = 18;
	  public static final int INSTANCEOF_PREDICATE = 19;
	  public static final int FIELD_ACTION = 20;
	  
	  public static final int ATTACHED_ACTION = 22;
	  public static final int MEMBER_ACTION = 23;
	  public static final int BASIC_PREDICATE = 24;
	  public static final int BINARY_PREDICATE = 25;
	  public static final int METHOD_PATTERN = 26;
	  public static final int FIELD_SIGNATURE = 27;
	  public static final int CONSTRUCTOR_SIGNATURE = 28;
	  public static final int METHOD_SIGNATURE = 29;
	  public static final int SIGNATURE = 30;
	  public static final int CALL_CONTEXT = 31;
	  
	  public static final int DEPLOYED_ATTACHMENTS = 97;
	  public static final int ADTHREAD = 98;
	  public static final int CONTINUE_EXECUTION = 99;
	  public static final int SOURCE_ROOT = 100;
	  public static final int DEBUG_INFO = 101;
	  public static final int SOURCE_STRING = 102;
	  public static final int BREAKPOINT = 103;
	  public static final int TERMINATE = 104;
	  
	  public static final int ADM_STRING = 1 + (ADMIRROR << 8);
	  
	  public static final int THREAD_FRAMES = 1 + (ADTHREAD << 8);
	  
	  public static final int DF_FUNCTION = 1 + (DISPATCH_FRAME << 8);
	  public static final int DF_CALL_CONTEXT = 2 + (DISPATCH_FRAME << 8);
	  public static final int DF_ACTIONS = 3 + (DISPATCH_FRAME << 8);
	  public static final int DF_EXE_ACT = 4 + (DISPATCH_FRAME << 8);
	  
	  public static final int GF_STRATEGY = 1 + (GENERIC_FUNCTION << 8);
	  public static final int GF_SIGNATURE = 2 + (GENERIC_FUNCTION << 8);
	  
	  public static final int SPLIT_VARIABLE = 1 + (SPLIT << 8);
	  public static final int SPLIT_HIGH = 2 + (SPLIT << 8);
	  public static final int SPLIT_LOW = 3 + (SPLIT << 8);
	  
	  public static final int SINK_ATTACTS = 1 + (SINK << 8);
	  public static final int SINK_ISCOMPLEMENTED = 2 + (SINK << 8);
	  
	  public static final int ATTA_SCHED_INFO = 1 + (ATTACHMENT << 8);
	  public static final int ATTA_ACTION = 2 + (ATTACHMENT << 8);
	  public static final int ATTA_SPECS = 3 + (ATTACHMENT << 8);
	  public static final int ATTA_DEPLOY = 4 + (ATTACHMENT << 8);
	  public static final int ATTA_UNDEPLOY = 5 + (ATTACHMENT << 8);
	  
	  public static final int SI_SKIPRULE = 1 + (SCHEDULE_INFO << 8);
	  public static final int SI_TIME = 2 + (SCHEDULE_INFO << 8);
	  	  
	  public static final int SPEC_PATTERN = 1 + (SPECIALIZATION << 8);
	  public static final int SPEC_PREDICATE = 2 + (SPECIALIZATION << 8);
	  public static final int SPEC_CONTEXTS = 3 + (SPECIALIZATION << 8);
	  
	  public static final int CTX_VALUE = 1 + (CONTEXT << 8);
	  public static final int CTX_TYPE = 2 + (CONTEXT << 8);
	  	
	  public static final int ATOMPRED_HAS_EVAL = 1 + (ATOMIC_PREDICATE << 8);
	  public static final int ATOMPRED_EVAL_RESULT = 2 + (ATOMIC_PREDICATE << 8);
	  
	  public static final int TYPEDES_NORMALNAME = 1 + (TYPE_DESCRIPTOR << 8);
	  
	  public static final int MCA_PARA_TYPES = 3 + (METHOD_CALL_ACTION << 8);
	  public static final int MCA_RESULT_TYPE = 4 + (METHOD_CALL_ACTION << 8);
	  public static final int MCA_CALL_TYPE = 5 + (METHOD_CALL_ACTION << 8);
	  
	  public static final int BOOLPRED_SUCCEEDS = 1 + (BOOLEAN_PREDICATE << 8);
	  
	  public static final int INSPRED_CTX = 2 + (INSTANCEOF_PREDICATE << 8);
	  public static final int INSPRED_REQTYPE = 3 + (INSTANCEOF_PREDICATE << 8);

	  
	  public static final int CC_CLEE = 1 + (CALL_CONTEXT << 8);
	  public static final int CC_CLEE_ARGS = 2 + (CALL_CONTEXT << 8);
	  public static final int CC_CLER_LCLS = 3 + (CALL_CONTEXT << 8);
	  public static final int CC_CLEE_CLSDES = 4 + (CALL_CONTEXT << 8);
	  public static final int CC_CLEE_NAME = 5 + (CALL_CONTEXT << 8);
	  public static final int CC_CLEE_ARGTYPES = 6 + (CALL_CONTEXT << 8);
	  public static final int CC_CLEE_RTNTYPE = 7 + (CALL_CONTEXT << 8);
	  public static final int CC_CLER_LCLTYPES = 8 + (CALL_CONTEXT << 8);
	  public static final int CC_CLER_LCLNMS = 9 + (CALL_CONTEXT << 8);
	  public static final int CC_CALL_LINE = 10 + (CALL_CONTEXT << 8);
	  public static final int CC_CLER_CLS = 11 + (CALL_CONTEXT << 8);
	  public static final int CC_CLER_NAME = 12 + (CALL_CONTEXT << 8);
	  public static final int CC_CLER_ARGTYPES = 13 + (CALL_CONTEXT << 8);
	  public static final int CC_CLER_RTNTYPE = 14 + (CALL_CONTEXT << 8);
	  public static final int CC_CLER_FILENM = 15 + (CALL_CONTEXT << 8);
	  public static final int CC_CALL_OPCODE = 16 + (CALL_CONTEXT << 8);
	  public static final int CC_CLER_MODIFIER = 17 + (CALL_CONTEXT << 8);
	  public static final int CC_THREAD = 18 + (CALL_CONTEXT << 8);
	  
	  public static final int SIG_MODIFIERS = 1 + (SIGNATURE << 8);
	  public static final int SIG_DECL_CLS = 2 + (SIGNATURE << 8);
	  public static final int SIG_NAME = 3 + (SIGNATURE << 8);
	  public static final int SIG_RTN_TYPE = 4 + (SIGNATURE << 8);
	  
	  
	  public static final int METSIG_PARA_TYPES = 1 + (METHOD_SIGNATURE << 8);
	  public static final int METSIG_EXCP_TYPES = 2 + (METHOD_SIGNATURE << 8);
	  
	  public static final int CONSIG_PARA_TYPES = 1 + (CONSTRUCTOR_SIGNATURE << 8);
	  public static final int CONSIG_EXCP_TYPES = 2 + (CONSTRUCTOR_SIGNATURE << 8);
	  
	  public static final int FSIG_TYPE = 1 + (FIELD_SIGNATURE << 8);
	  public static final int FSIG_ISREAD = 2 + (FIELD_SIGNATURE << 8);
	  
	  public static final int MP_MODI_PTN = 1 + (METHOD_PATTERN << 8);
	  public static final int MP_TYPE_PTN = 2 + (METHOD_PATTERN << 8);
	  public static final int MP_CLS_PTN = 3 + (METHOD_PATTERN << 8);
	  public static final int MP_NAME_PTN = 4 + (METHOD_PATTERN << 8);
	  public static final int MP_PARA_PTN = 5 + (METHOD_PATTERN << 8);
	  public static final int MP_EXCP_PTN = 6 + (METHOD_PATTERN << 8);
	  
	  public static final int BIPRED_LEFT = 1 + (BINARY_PREDICATE << 8);
	  public static final int BIPRED_RIGHT = 2 + (BINARY_PREDICATE << 8);
	  
	  public static final int BSCP_POSITIVE = 1 + (BASIC_PREDICATE << 8);
	  public static final int BSCP_ATOM = 2 + (BASIC_PREDICATE << 8);
	  
	  public static final int MA_CLS = 1 + (MEMBER_ACTION << 8);
	  public static final int MA_NAME = 2 + (MEMBER_ACTION << 8);
	  
	  public static final int ATTACT_SCHED_INFO = 1 + (ATTACHED_ACTION << 8);
	  public static final int ATTACT_ACTION = 2 + (ATTACHED_ACTION << 8);
	  public static final int ATTACT_CTXS = 3 + (ATTACHED_ACTION << 8);
	  
	  public static final int DINFO_FILE_NAME = 1 + (DEBUG_INFO << 8);
	  public static final int DINFO_START_LINE = 2 + (DEBUG_INFO << 8);
	  public static final int DINFO_END_LINE = 3 + (DEBUG_INFO << 8);
	  
	  public static final int FDACT_TYPE = 1 + (FIELD_ACTION << 8);
	  public static final int FDACT_ISREAD = 2 + (FIELD_ACTION << 8);
	  
	  public static final int BREAKPOINT_ADD = 1 + (BREAKPOINT << 8);
	  public static final int BREAKPOINT_REMOVE = 2 + (BREAKPOINT << 8);
	  public static final int BREAKPOINT_CHECK = 3 + (BREAKPOINT << 8);
	  public static final int BREAKPOINT_UNCHECK = 4 + (BREAKPOINT << 8);
	  
	  private static HashMap<Integer, String> constantMap;
	  
	  public static String commandName(int command) {
		  if(constantMap == null) {
			  constantMap = new HashMap<Integer, String>();
			  Field[] fields = AddbCommand.class.getDeclaredFields();
				
			  for (Field field : fields) {
				if ((field.getModifiers() & Modifier.PUBLIC) == 0 || (field.getModifiers() & Modifier.STATIC) == 0 || (field.getModifiers() & Modifier.FINAL) == 0) {
					continue;
				}
				try {
					constantMap.put((Integer) field.get(null), field.getName());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			  }
		  }
		  return constantMap.get(command);
	  }
}
