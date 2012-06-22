package org.alia4j.fial;

import org.alia4j.liam.ActionTime;
import org.alia4j.liam.ScheduleInfo;
import org.alia4j.liam.ScheduleRule;

/**
 * This schedule info is to be used by system attachments whose scheduling should overrule the scheduling of user defined
 * advice. E.g., system attachments may require to be always executed before or after all used attached attachments. System
 * attachments are ordered according to their priority. There are two rules to be specified: system attachments can be
 * executed (1) closes to the implicit action or (2) farthest away from the implicit action. Attachments with a
 * SystemScheduleInfo are ordered by their priority. I.e., if multiple system attachments are attached at a generic function
 * that one with the highest priority will be executed closest to or farthest away from the implicit action.
 * 
 * @author Christoph Bockisch
 */
final public class SystemScheduleInfo extends ScheduleInfo {
    
    protected SystemScheduleInfo(ActionTime time, ScheduleRule rule) {
        super(time, rule);
    }
    
    public static final SystemScheduleInfo IMPLICIT_ACTION = new SystemScheduleInfo(ActionTime.AROUND,
                    ScheduleRule.IMPLICIT_ACTION);
    
    public static final SystemScheduleInfo BEFORE_FARTHEST = new SystemScheduleInfo(ActionTime.BEFORE,
                    ScheduleRule.FARTHEST_FROM_IMPLICIT_ACTION);
    
    public static final SystemScheduleInfo AFTER_FARTHEST = new SystemScheduleInfo(ActionTime.AFTER,
                    ScheduleRule.FARTHEST_FROM_IMPLICIT_ACTION);
    
    public static final SystemScheduleInfo AROUND_FARTHEST = new SystemScheduleInfo(ActionTime.AROUND,
                    ScheduleRule.FARTHEST_FROM_IMPLICIT_ACTION);
    
    public static final SystemScheduleInfo BEFORE_CLOSEST = new SystemScheduleInfo(ActionTime.BEFORE,
                    ScheduleRule.CLOSEST_TO_IMPLICIT_ACTION);
    
    public static final SystemScheduleInfo AFTER_CLOSEST = new SystemScheduleInfo(ActionTime.AFTER,
                    ScheduleRule.CLOSEST_TO_IMPLICIT_ACTION);
    
    public static final SystemScheduleInfo AROUND_CLOSEST = new SystemScheduleInfo(ActionTime.AROUND,
                    ScheduleRule.CLOSEST_TO_IMPLICIT_ACTION);
    
}
