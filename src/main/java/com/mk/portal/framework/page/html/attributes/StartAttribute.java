package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class StartAttribute implements Attribute {
	private String value;
	public StartAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "start";
	}

	@Override
	public String getValue() {
		return value;
	}
}
