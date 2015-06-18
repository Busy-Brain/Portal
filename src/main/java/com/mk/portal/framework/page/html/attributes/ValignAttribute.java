package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ValignAttribute implements Attribute {
	private String value;
	public ValignAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "valign";
	}

	@Override
	public String getValue() {
		return value;
	}
}
