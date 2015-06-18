package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ContextmenuAttribute implements Attribute {
	private String value;
	public ContextmenuAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "contextmenu";
	}

	@Override
	public String getValue() {
		return value;
	}
}
