package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class CompactAttribute implements Attribute {
	private String value;
	public CompactAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "compact";
	}

	@Override
	public String getValue() {
		return value;
	}
}
