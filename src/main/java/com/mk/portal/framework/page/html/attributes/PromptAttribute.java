package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class PromptAttribute implements Attribute {
	private String value;
	public PromptAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "prompt";
	}

	@Override
	public String getValue() {
		return value;
	}
}
