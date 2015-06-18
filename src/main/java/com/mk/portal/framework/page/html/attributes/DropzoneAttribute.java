package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class DropzoneAttribute implements Attribute {
	private String value;
	public DropzoneAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "dropzone";
	}

	@Override
	public String getValue() {
		return value;
	}
}
