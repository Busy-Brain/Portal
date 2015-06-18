package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class AlinkAttribute implements Attribute {
	private String value;
	public AlinkAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "alink";
	}

	@Override
	public String getValue() {
		return value;
	}
}
