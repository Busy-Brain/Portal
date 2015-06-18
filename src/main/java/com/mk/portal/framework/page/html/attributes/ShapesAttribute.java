package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ShapesAttribute implements Attribute {
	private String value;
	public ShapesAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "shapes";
	}

	@Override
	public String getValue() {
		return value;
	}
}
