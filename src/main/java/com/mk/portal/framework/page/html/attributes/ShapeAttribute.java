package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ShapeAttribute implements Attribute {
	private String value;
	public ShapeAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "shape";
	}

	@Override
	public String getValue() {
		return value;
	}
}
