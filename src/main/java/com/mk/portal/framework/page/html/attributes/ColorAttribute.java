package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ColorAttribute implements Attribute {
	private String value;
	public ColorAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "color";
	}

	@Override
	public String getValue() {
		return value;
	}
}
