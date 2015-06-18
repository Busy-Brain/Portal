package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ClearAttribute implements Attribute {
	private String value;
	public ClearAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "clear";
	}

	@Override
	public String getValue() {
		return value;
	}
}
