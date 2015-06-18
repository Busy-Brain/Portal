package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class RowspanAttribute implements Attribute {
	private String value;
	public RowspanAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "rowspan";
	}

	@Override
	public String getValue() {
		return value;
	}
}
