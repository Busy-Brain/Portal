package com.mk.portal.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.html.objects.Page;
import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.page.PageIdentifier;
import com.mk.portal.framework.page.html.tags.Text;
import com.mk.portal.framework.service.PageDetailsService;

public class PageDetailsServiceImpl implements PageDetailsService {

	public Page getpage(PageIdentifier pageId) {
		List<PageComponent> pageComponents=new ArrayList<PageComponent>();
		pageComponents.add(new Text("Hello World"));
		return new Page(pageComponents);
	}

}
