package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class RelAttribute implements Attribute {
	private String value;
	public RelAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "rel";
	}

	@Override
	public String getValue() {
		return value;
	}
}
