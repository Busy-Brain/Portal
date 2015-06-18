package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class HttpequivAttribute implements Attribute {
	private String value;
	public HttpequivAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "http-equiv";
	}

	@Override
	public String getValue() {
		return value;
	}
}
