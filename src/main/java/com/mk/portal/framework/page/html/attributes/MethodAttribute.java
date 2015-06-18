package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class MethodAttribute implements Attribute {
	private String value;
	public MethodAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "method";
	}

	@Override
	public String getValue() {
		return value;
	}
}
