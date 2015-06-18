package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class LowsrcAttribute implements Attribute {
	private String value;
	public LowsrcAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "lowsrc";
	}

	@Override
	public String getValue() {
		return value;
	}
}
