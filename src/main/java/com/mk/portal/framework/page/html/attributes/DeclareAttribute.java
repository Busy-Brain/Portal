package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class DeclareAttribute implements Attribute {
	private String value;
	public DeclareAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "declare";
	}

	@Override
	public String getValue() {
		return value;
	}
}
