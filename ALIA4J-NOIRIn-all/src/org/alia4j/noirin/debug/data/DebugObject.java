package org.alia4j.noirin.debug.data;


public class DebugObject {
  private int id;
  private Object object;
  
  DebugObject(int id, Object variable) {
    this.id = id;
    this.object = variable;
  }
  public int id() {
    return id;
  }
  
  public Object object() {
    return object;
  }
}
