package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class AlignAttribute implements Attribute {
	private String value;
	public AlignAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "align";
	}

	@Override
	public String getValue() {
		return value;
	}
}
