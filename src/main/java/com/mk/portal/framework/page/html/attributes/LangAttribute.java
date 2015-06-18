package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class LangAttribute implements Attribute {
	private String value;
	public LangAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "lang";
	}

	@Override
	public String getValue() {
		return value;
	}
}
