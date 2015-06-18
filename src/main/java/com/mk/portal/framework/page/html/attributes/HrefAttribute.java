package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class HrefAttribute implements Attribute {
	private String value;
	public HrefAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "href";
	}

	@Override
	public String getValue() {
		return value;
	}
}
