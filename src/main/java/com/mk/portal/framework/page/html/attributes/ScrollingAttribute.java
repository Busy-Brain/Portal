package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ScrollingAttribute implements Attribute {
	private String value;
	public ScrollingAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "scrolling";
	}

	@Override
	public String getValue() {
		return value;
	}
}
