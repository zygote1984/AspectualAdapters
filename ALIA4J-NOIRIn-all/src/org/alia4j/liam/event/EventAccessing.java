package org.alia4j.liam.event;

public interface EventAccessing {
    
    public boolean isTriggered();
    
    public boolean getBooleanValue(String parameterName);
    
    public char getCharValue(String parameterName);
    
    public byte getByteValue(String parameterName);
    
    public short getShortValue(String parameterName);
    
    public int getIntValue(String parameterName);
    
    public long getLongValue(String parameterName);
    
    public float getFloatValue(String parameterName);
    
    public double getDoubleValue(String parameterName);
    
    public Object getObjectValue(String parameterName);
    
}
