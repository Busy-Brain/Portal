package com.mk.portal.framework.page.html.components;

import com.mk.portal.framework.html.objects.AbstractComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.tags.DivTag;
import com.mk.portal.framework.page.html.tags.H1Tag;
import com.mk.portal.framework.page.html.tags.Text;

public class PageHeaderComponent extends AbstractComponent{
	public PageHeaderComponent() {
		this("Default Page Header Text");
	}
	public PageHeaderComponent(String text) {
		super();
		this.text = text;
	}

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	protected TagComponent getComponent() {
		DivTag header = new DivTag();
		header.addAttribute(new ClassAttribute("page-header"));
		H1Tag headerText=new H1Tag();
		headerText.addChild(new Text(text));
		header.addChild(headerText);
		return header;
	}

}
