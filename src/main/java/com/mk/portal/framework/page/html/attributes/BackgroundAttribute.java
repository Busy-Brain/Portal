package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class BackgroundAttribute implements Attribute {
	private String value;
	public BackgroundAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "background";
	}

	@Override
	public String getValue() {
		return value;
	}
}
