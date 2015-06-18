package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class NowrapAttribute implements Attribute {
	private String value;
	public NowrapAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "nowrap";
	}

	@Override
	public String getValue() {
		return value;
	}
}
