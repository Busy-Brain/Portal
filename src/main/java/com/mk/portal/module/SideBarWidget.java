package com.mk.portal.module;

import com.mk.portal.framework.page.content.HTMLContent;
import com.mk.portal.framework.service.PortalVO;
import com.mk.portal.framework.widget.Widget;

public class SideBarWidget implements Widget{

	public String getName() {
		return "SideBarWidget";
	}

	public HTMLContent getScreenContent() {
		return new HTMLContent("HTML Content of Side Bar Widget");
	}

	public HTMLContent getBackEndServiceName() {
		return null;
	}

	public void setUp(PortalVO setupVO) {
		
	}

	public Widget clone() {
		try {
			return (Widget) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AssertionError();
		}
	}

}
