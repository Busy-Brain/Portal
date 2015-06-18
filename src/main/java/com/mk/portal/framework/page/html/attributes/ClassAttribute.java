package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ClassAttribute implements Attribute {
	private String value;
	public ClassAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "class";
	}

	@Override
	public String getValue() {
		return value;
	}
}
