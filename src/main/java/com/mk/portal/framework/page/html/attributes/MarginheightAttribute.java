package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class MarginheightAttribute implements Attribute {
	private String value;
	public MarginheightAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "marginheight";
	}

	@Override
	public String getValue() {
		return value;
	}
}
