package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class SrcAttribute implements Attribute {
	private String value;
	public SrcAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "src";
	}

	@Override
	public String getValue() {
		return value;
	}
}
