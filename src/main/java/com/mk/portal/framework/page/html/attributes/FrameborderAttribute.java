package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class FrameborderAttribute implements Attribute {
	private String value;
	public FrameborderAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "frameborder";
	}

	@Override
	public String getValue() {
		return value;
	}
}
