package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class StyleAttribute implements Attribute {
	private String value;
	public StyleAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "style";
	}

	@Override
	public String getValue() {
		return value;
	}
}
