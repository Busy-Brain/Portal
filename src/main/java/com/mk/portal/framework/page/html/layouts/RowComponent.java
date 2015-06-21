package com.mk.portal.framework.page.html.layouts;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.html.objects.AbstractComponent;
import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.tags.DivTag;

public class RowComponent extends AbstractComponent{
	private List<PageComponent> children= new ArrayList<PageComponent>();

	@Override
	protected TagComponent getComponent() {
		DivTag row=new DivTag();
		row.addAttribute(new ClassAttribute("row"));
		return row;
	}

}
