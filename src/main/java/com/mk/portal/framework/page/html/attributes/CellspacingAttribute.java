package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class CellspacingAttribute implements Attribute {
	private String value;
	public CellspacingAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "cellspacing";
	}

	@Override
	public String getValue() {
		return value;
	}
}
