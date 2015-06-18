package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class HeightAttribute implements Attribute {
	private String value;
	public HeightAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "height";
	}

	@Override
	public String getValue() {
		return value;
	}
}
