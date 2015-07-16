package com.mk.portal.framework.page.html.components;

import com.mk.portal.framework.html.objects.AbstractComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.attributes.HREFAttribute;
import com.mk.portal.framework.page.html.tags.ATag;
import com.mk.portal.framework.page.html.tags.LiTag;
import com.mk.portal.framework.page.html.tags.Text;
import com.mk.portal.framework.page.html.tags.UlTag;

public class TopBarComponent extends AbstractComponent {

	@Override
	protected TagComponent getComponent() {

		UlTag topLinks = new UlTag();
		topLinks.addAttribute(new ClassAttribute("nav navbar-nav navbar-right"));
		LiTag link1 = new LiTag();
		ATag a1 = new ATag();
		a1.addAttribute(new HREFAttribute("/qbank/logout"));
		a1.addChild(new Text("Logout"));
		link1.addChild(a1);
		topLinks.addChild(link1);
		return topLinks;
	}

}
