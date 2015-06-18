package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class CharsetAttribute implements Attribute {
	private String value;
	public CharsetAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "charset";
	}

	@Override
	public String getValue() {
		return value;
	}
}
