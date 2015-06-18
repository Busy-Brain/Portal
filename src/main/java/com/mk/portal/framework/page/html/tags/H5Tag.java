package com.mk.portal.framework.page.html.tags;

import com.mk.portal.framework.html.objects.Tag;

public class H5Tag extends Tag {

	@Override
	public boolean hasEndTag() {
		return true;
	}

	
	@Override
	public String getTagName() {
		return "h5";
	}

}
