package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class RowsAttribute implements Attribute {
	private String value;
	public RowsAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "rows";
	}

	@Override
	public String getValue() {
		return value;
	}
}
