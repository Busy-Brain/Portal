package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class DummyAttribute implements Attribute {
	private String value;
	public DummyAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "dummy";
	}

	@Override
	public String getValue() {
		return value;
	}
}
