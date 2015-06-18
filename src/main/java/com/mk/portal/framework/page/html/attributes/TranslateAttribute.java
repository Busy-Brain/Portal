package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class TranslateAttribute implements Attribute {
	private String value;
	public TranslateAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "translate";
	}

	@Override
	public String getValue() {
		return value;
	}
}
