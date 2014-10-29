package com.mk.portal.framework.page.tags;

public class MetaTagObject {
private String name;
private String content;
public String getName() {
	return name;
}
public String getContent() {
	return content;
}
public MetaTagObject(String name, String content) {
	super();
	this.name = name;
	this.content = content;
}
@Override
public String toString() {
	return "<meta name=\""+name+"\" content=\""+content+"\">";
	
}

}
