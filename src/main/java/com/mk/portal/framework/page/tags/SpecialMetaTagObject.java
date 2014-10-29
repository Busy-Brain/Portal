package com.mk.portal.framework.page.tags;

public class SpecialMetaTagObject {
private String attributeName;
private String attributeValue;

public SpecialMetaTagObject(String attributeName, String attributeValue) {
	super();
	this.attributeName = attributeName;
	this.attributeValue = attributeValue;
}
public String getAttributeName() {
	return attributeName;
}
public String getAttributeValue() {
	return attributeValue;
}
@Override
public String toString() {
	return "<meta " + attributeName
			+ "=\"" + attributeValue + "\">";
}

}
