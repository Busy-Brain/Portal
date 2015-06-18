package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ClassidAttribute implements Attribute {
	private String value;
	public ClassidAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "classid";
	}

	@Override
	public String getValue() {
		return value;
	}
}
