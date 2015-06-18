package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class TitleAttribute implements Attribute {
	private String value;
	public TitleAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "title";
	}

	@Override
	public String getValue() {
		return value;
	}
}
