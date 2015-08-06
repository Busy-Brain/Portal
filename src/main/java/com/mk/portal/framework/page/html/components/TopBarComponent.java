package com.mk.portal.framework.page.html.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mk.portal.framework.html.objects.AbstractTagComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.model.PortalLink;
import com.mk.portal.framework.page.html.attributes.AltAttribute;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.attributes.HREFAttribute;
import com.mk.portal.framework.page.html.tags.ATag;
import com.mk.portal.framework.page.html.tags.LiTag;
import com.mk.portal.framework.page.html.tags.Text;
import com.mk.portal.framework.page.html.tags.UlTag;
import com.mk.portal.framework.service.impl.LinkServiceImpl;
@Component
public class TopBarComponent extends AbstractTagComponent {
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
		
		UlTag topLinks = new UlTag();
		topLinks.addAttribute(new ClassAttribute("nav navbar-nav navbar-right"));
		List<PortalLink> links= linksServiceImpl.findTopLevelLinksForSite("1");
		for(PortalLink l:links){
			if(l.isVisible()){
				LiTag link1 = new LiTag();
				ATag a1 = new ATag();
				a1.addAttribute(new HREFAttribute(l.getUrl()));
				a1.addAttribute(new AltAttribute(l.getAlt()));
				a1.addChild(new Text(l.getText()));
				link1.addChild(a1);
				topLinks.addChild(link1);
			}
			
		}
		return topLinks;
	}

}
