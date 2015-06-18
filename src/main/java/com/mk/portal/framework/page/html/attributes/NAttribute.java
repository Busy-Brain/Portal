package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class NAttribute implements Attribute {
	private String value;
	public NAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "n";
	}

	@Override
	public String getValue() {
		return value;
	}
}
