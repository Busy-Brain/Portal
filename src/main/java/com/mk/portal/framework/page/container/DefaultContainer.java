package com.mk.portal.framework.page.container;

import com.mk.portal.framework.page.content.Content;

public class DefaultContainer implements Container {
	private Content content;
	public DefaultContainer(Content htmlContent) {
		content=htmlContent;
	}

	@Override
	public Content getContents() {
		return content;
	}

}
