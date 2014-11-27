package com.mk.portal.framework.page.tags;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PortalPageTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 644086034015024391L;
	@Override
	 public int doStartTag() throws JspException
	    {
	        try
	        {
	            JspWriter out = pageContext.getOut();
	            HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
	            out.write("Hello world!");
	        }
	        catch(Exception e)
	        {   
	            throw new JspException(e.getMessage());
	        }
	        return EVAL_PAGE;
	    }
	@Override
	 public int doEndTag() throws JspException
	    {
	        try
	        {
	            JspWriter out = pageContext.getOut();
	            HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
	            out.write("Bye world!");
	        }
	        catch(Exception e)
	        {   
	            throw new JspException(e.getMessage());
	        }
	        return EVAL_PAGE;
	    }
}
