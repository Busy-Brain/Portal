package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class SelectedAttribute implements Attribute {
	private String value;
	public SelectedAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "selected";
	}

	@Override
	public String getValue() {
		return value;
	}
}
