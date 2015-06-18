package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class DraggableAttribute implements Attribute {
	private String value;
	public DraggableAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "draggable";
	}

	@Override
	public String getValue() {
		return value;
	}
}
