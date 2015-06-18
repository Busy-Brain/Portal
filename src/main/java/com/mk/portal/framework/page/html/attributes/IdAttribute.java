package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class IdAttribute implements Attribute {
	private String value;
	public IdAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "id";
	}

	@Override
	public String getValue() {
		return value;
	}
}
