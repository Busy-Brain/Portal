package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class MediaAttribute implements Attribute {
	private String value;
	public MediaAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "media";
	}

	@Override
	public String getValue() {
		return value;
	}
}
