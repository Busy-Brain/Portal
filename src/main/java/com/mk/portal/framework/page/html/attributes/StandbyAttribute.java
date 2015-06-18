package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class StandbyAttribute implements Attribute {
	private String value;
	public StandbyAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "standby";
	}

	@Override
	public String getValue() {
		return value;
	}
}
