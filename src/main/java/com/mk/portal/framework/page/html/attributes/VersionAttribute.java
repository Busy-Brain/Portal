package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class VersionAttribute implements Attribute {
	private String value;
	public VersionAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "version";
	}

	@Override
	public String getValue() {
		return value;
	}
}
