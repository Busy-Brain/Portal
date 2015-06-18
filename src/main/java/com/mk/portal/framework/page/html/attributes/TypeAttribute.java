package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class TypeAttribute implements Attribute {
	private String value;
	public TypeAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "type";
	}

	@Override
	public String getValue() {
		return value;
	}
}
