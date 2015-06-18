package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class RevAttribute implements Attribute {
	private String value;
	public RevAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "rev";
	}

	@Override
	public String getValue() {
		return value;
	}
}
