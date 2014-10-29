package com.mk.portal.framework.page.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public abstract class PortalTag extends SimpleTagSupport{
	protected String pageId;
	
	@Override
	 public void doTag() throws JspException, IOException {
		    getJspContext().getOut().println(prepareTagStatement());
		  }
	protected abstract String prepareTagStatement() ;
	
	public String getPageId() {
		return pageId;
	}
	
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
}
