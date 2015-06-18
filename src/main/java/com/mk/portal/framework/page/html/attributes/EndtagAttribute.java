package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class EndtagAttribute implements Attribute {
	private String value;
	public EndtagAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "endtag";
	}

	@Override
	public String getValue() {
		return value;
	}
}
