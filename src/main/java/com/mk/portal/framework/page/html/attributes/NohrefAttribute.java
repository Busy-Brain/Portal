package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class NohrefAttribute implements Attribute {
	private String value;
	public NohrefAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "nohref";
	}

	@Override
	public String getValue() {
		return value;
	}
}
