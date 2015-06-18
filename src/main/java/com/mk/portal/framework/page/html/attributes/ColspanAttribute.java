package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ColspanAttribute implements Attribute {
	private String value;
	public ColspanAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "colspan";
	}

	@Override
	public String getValue() {
		return value;
	}
}
