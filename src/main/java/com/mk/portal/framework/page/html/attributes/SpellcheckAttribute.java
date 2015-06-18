package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class SpellcheckAttribute implements Attribute {
	private String value;
	public SpellcheckAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "spellcheck";
	}

	@Override
	public String getValue() {
		return value;
	}
}
