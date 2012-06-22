package org.alia4j.liam;

public class ScheduleInfo {
    
    private final ActionTime time;
    
    private final ScheduleRule rule;
    
    public static final ScheduleInfo BEFORE = new ScheduleInfo(ActionTime.BEFORE);
    
    public static final ScheduleInfo AFTER = new ScheduleInfo(ActionTime.AFTER);
    
    public static final ScheduleInfo AROUND = new ScheduleInfo(ActionTime.AROUND);
    
    public static final ScheduleInfo WHEN = new ScheduleInfo(ActionTime.WHEN);
    
    public static ScheduleInfo findScheduleInfo(ActionTime actionTime) {
        switch (actionTime) {
        case BEFORE:
            return ScheduleInfo.BEFORE;
        case AFTER:
            return ScheduleInfo.AFTER;
        case AROUND:
            return ScheduleInfo.AROUND;
        case WHEN:
            return ScheduleInfo.WHEN;
            
        default:
            throw new IllegalArgumentException();
        }
    }
    
    /**
     * @param time may not be {@code null}.
     * @param rule may not be {@code null}.
     */
    protected ScheduleInfo(final ActionTime time, final ScheduleRule rule) {
        this.time = time;
        this.rule = rule;
    }
    
    public ScheduleRule getRule() {
        return this.rule;
    }
    
    protected ScheduleInfo(ActionTime time) {
        this(time, ScheduleRule.DEFAULT);
    }
    
    public ActionTime getTime() {
        return this.time;
    }
    
    @Override
    public String toString() {
        return "ScheduleInfo [time=" + this.time + ", rule=" + this.rule + "]";
    }
    
}
