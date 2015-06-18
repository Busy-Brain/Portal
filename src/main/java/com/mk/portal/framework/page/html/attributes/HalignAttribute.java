package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class HalignAttribute implements Attribute {
	private String value;
	public HalignAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "halign";
	}

	@Override
	public String getValue() {
		return value;
	}
}
