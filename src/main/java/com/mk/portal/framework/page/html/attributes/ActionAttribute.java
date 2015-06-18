package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ActionAttribute implements Attribute {
	private String value;
	public ActionAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "action";
	}

	@Override
	public String getValue() {
		return value;
	}
}
