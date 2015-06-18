package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class CoordsAttribute implements Attribute {
	private String value;
	public CoordsAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "coords";
	}

	@Override
	public String getValue() {
		return value;
	}
}
