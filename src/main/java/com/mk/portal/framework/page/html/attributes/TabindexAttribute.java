package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class TabindexAttribute implements Attribute {
	private String value;
	public TabindexAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "tabindex";
	}

	@Override
	public String getValue() {
		return value;
	}
}
