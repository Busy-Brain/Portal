package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class NoresizeAttribute implements Attribute {
	private String value;
	public NoresizeAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "noresize";
	}

	@Override
	public String getValue() {
		return value;
	}
}
