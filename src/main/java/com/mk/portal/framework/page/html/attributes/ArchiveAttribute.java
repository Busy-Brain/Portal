package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ArchiveAttribute implements Attribute {
	private String value;
	public ArchiveAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "archive";
	}

	@Override
	public String getValue() {
		return value;
	}
}
