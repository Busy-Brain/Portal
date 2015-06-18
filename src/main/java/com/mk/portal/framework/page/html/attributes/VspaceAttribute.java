package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class VspaceAttribute implements Attribute {
	private String value;
	public VspaceAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "vspace";
	}

	@Override
	public String getValue() {
		return value;
	}
}
