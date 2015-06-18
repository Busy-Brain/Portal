package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class SizeAttribute implements Attribute {
	private String value;
	public SizeAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "size";
	}

	@Override
	public String getValue() {
		return value;
	}
}
