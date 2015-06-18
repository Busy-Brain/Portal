package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class CheckedAttribute implements Attribute {
	private String value;
	public CheckedAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "checked";
	}

	@Override
	public String getValue() {
		return value;
	}
}
