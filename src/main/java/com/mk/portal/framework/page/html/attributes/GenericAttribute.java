package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class GenericAttribute implements Attribute {
	private String value;
	private String name;
	public GenericAttribute(String name,String val){
		this.name=name;
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		return value;
	}
}
