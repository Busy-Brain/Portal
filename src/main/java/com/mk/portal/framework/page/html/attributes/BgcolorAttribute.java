package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class BgcolorAttribute implements Attribute {
	private String value;
	public BgcolorAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "bgcolor";
	}

	@Override
	public String getValue() {
		return value;
	}
}
