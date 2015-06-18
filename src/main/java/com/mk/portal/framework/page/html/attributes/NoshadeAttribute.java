package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class NoshadeAttribute implements Attribute {
	private String value;
	public NoshadeAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "noshade";
	}

	@Override
	public String getValue() {
		return value;
	}
}
