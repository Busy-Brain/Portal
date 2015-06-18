package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class DirAttribute implements Attribute {
	private String value;
	public DirAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "dir";
	}

	@Override
	public String getValue() {
		return value;
	}
}
