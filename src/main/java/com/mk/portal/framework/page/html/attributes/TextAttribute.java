package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class TextAttribute implements Attribute {
	private String value;
	public TextAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "text";
	}

	@Override
	public String getValue() {
		return value;
	}
}
