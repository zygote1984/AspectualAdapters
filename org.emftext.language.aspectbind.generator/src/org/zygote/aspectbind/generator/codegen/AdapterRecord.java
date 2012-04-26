package org.zygote.aspectbind.generator.codegen;

import org.emftext.language.aspectbind.binding.InstancePointcut;

public class AdapterRecord {

	String adapterName;
	String instanceType;
	boolean subtype;
	String parent;
	
	public AdapterRecord(String adapterName,
			String instanceType, boolean subtype, String subType_) {
		super();
		this.adapterName = adapterName;
		this.instanceType = instanceType;
		this.subtype = subtype;
		this.parent = subType_;
	}


	public AdapterRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getParent() {
		return parent;
	}
	
	public void setParent(String subType_) {
		this.parent = subType_;
	}

	public String getAdapterName() {
		return adapterName;
	}

	public void setAdapterName(String adapterName) {
		this.adapterName = adapterName;
	}

	public String getInstanceType() {
		return instanceType;
	}

	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}

	public boolean isSubtype() {
		return subtype;
	}

	public void setSubtype(boolean subtype) {
		this.subtype = subtype;
	}

}
