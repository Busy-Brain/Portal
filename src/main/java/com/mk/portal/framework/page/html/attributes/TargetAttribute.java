package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class TargetAttribute implements Attribute {
	private String value;
	public TargetAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "target";
	}

	@Override
	public String getValue() {
		return value;
	}
}
