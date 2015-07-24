package com.mk.portal.framework.page.html.tags;

import java.util.List;

import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.model.PortalPage;

/**
 * The comment tag is used to insert comments in the source code. Comments are
 * not displayed in the browsers.
 * 
 * You can use comments to explain your code, which can help you when you edit
 * the source code at a later date. This is especially useful if you have a lot
 * of code.
 * 
 * @author mohit
 *
 */
public class Comment implements PageComponent {
	private String value;
	private PortalPage page;
	public Comment(String string) {
		this.value = string;
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

	@Override
	public TagComponent clone() {
		try {
			return (TagComponent) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new AssertionError();
		}
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public List<PageComponent> getChildren() {
		return null;
	}

	@Override
	public String toFormattedString(int tabcount) {
		return getTabs(tabcount)+"<!--" + this.value + "-->"+"\n";
	}
	@Override
	public String toString() {
		return "";
	}


	private String getTabs(int tabcount) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<tabcount;i++){
			sb.append("\t");
		}
		return sb.toString();
	}

	@Override
	public void addChild(PageComponent child) {
		
	}


	@Override
	public PortalPage getPage() {
		return page;
	}


	@Override
	public void setPage(PortalPage page) {
		this.page=page;
		
	}

	
}
