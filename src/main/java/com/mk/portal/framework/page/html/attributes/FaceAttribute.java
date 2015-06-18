package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class FaceAttribute implements Attribute {
	private String value;
	public FaceAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "face";
	}

	@Override
	public String getValue() {
		return value;
	}
}
