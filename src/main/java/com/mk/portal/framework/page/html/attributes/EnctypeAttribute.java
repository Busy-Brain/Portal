package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class EnctypeAttribute implements Attribute {
	private String value;
	public EnctypeAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "enctype";
	}

	@Override
	public String getValue() {
		return value;
	}
}
