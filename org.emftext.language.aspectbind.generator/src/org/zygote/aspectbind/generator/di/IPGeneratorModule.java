package org.zygote.aspectbind.generator.di;

import org.zygote.aspectbind.generator.codegen.ALIA4JGenerator;

import com.google.inject.AbstractModule;

public class IPGeneratorModule  extends AbstractModule {
	  @Override 
	  protected void configure() {
	    bind(IALIA4JGenerator.class).to(ALIA4JGenerator.class);
	  }
	  
	  
	  
}