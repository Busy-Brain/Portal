package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class AltAttribute implements Attribute {
	private String value;
	public AltAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "alt";
	}

	@Override
	public String getValue() {
		return value;
	}
}
