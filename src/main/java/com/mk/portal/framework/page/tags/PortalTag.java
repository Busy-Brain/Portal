package com.mk.portal.framework.page.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * This is base class for all portal tags.
 * 
 * @author mohit
 *
 */
public abstract class PortalTag extends SimpleTagSupport {
	/**
	 * Overriding the doTag to return the tag HTML as String.
	 */
	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().println(getTagHTML());
	}
	/**
	 * This method returns the tag HTMl
	 * @return
	 */
	protected abstract String getTagHTML();

}
