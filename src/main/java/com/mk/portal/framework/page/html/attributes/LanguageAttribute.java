package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class LanguageAttribute implements Attribute {
	private String value;
	public LanguageAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "language";
	}

	@Override
	public String getValue() {
		return value;
	}
}
