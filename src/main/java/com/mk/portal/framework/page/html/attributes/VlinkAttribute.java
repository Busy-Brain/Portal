package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class VlinkAttribute implements Attribute {
	private String value;
	public VlinkAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "vlink";
	}

	@Override
	public String getValue() {
		return value;
	}
}
