package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class CodebaseAttribute implements Attribute {
	private String value;
	public CodebaseAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "codebase";
	}

	@Override
	public String getValue() {
		return value;
	}
}
