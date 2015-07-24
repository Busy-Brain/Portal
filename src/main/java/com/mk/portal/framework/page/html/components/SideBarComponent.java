package com.mk.portal.framework.page.html.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.html.objects.AbstractComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.model.PortalLink;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.attributes.HREFAttribute;
import com.mk.portal.framework.page.html.tags.ATag;
import com.mk.portal.framework.page.html.tags.DivTag;
import com.mk.portal.framework.page.html.tags.LiTag;
import com.mk.portal.framework.page.html.tags.Text;
import com.mk.portal.framework.page.html.tags.UlTag;
import com.mk.portal.framework.service.impl.LinkServiceImpl;
import com.mk.portal.framework.service.impl.PageDetailsServiceImpl;

public class SideBarComponent extends AbstractComponent{
	@Autowired
	private LinkServiceImpl linksServiceImpl ;
	public LinkServiceImpl getLinksServiceImpl() {
		return linksServiceImpl;
	}
	public void setLinksServiceImpl(LinkServiceImpl linksServiceImpl) {
		this.linksServiceImpl = linksServiceImpl;
	}
	@Override
	protected TagComponent getComponent() {
		DivTag sidebar= new DivTag();
		sidebar.addAttribute(new ClassAttribute("container-fluid sidebar visible-desktop"));
		UlTag ul = new UlTag();
		ul.addAttribute(new ClassAttribute("nav nav-sidebar"));
		
		String pageLinkId=getPage().getPageLinkId();
		List<PortalLink> links=linksServiceImpl.getChildLinksForParent(pageLinkId);
		
		for(PortalLink link:links){
			LiTag li = new LiTag();
			ATag a= new ATag();
			a.addAttribute(new HREFAttribute(link.getUrl()));
			a.addChild(new Text(link.getText()));
			li.addChild(a);
			ul.addChild(li);
		}
		sidebar.addChild(ul);
		return sidebar;
	}

}
