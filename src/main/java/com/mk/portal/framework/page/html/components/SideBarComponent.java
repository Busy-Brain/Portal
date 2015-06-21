package com.mk.portal.framework.page.html.components;

import com.mk.portal.framework.html.objects.AbstractComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.attributes.HREFAttribute;
import com.mk.portal.framework.page.html.tags.ATag;
import com.mk.portal.framework.page.html.tags.DivTag;
import com.mk.portal.framework.page.html.tags.LiTag;
import com.mk.portal.framework.page.html.tags.Text;
import com.mk.portal.framework.page.html.tags.UlTag;

public class SideBarComponent extends AbstractComponent{
	
	@Override
	protected TagComponent getComponent() {
		DivTag sidebar= new DivTag();
		sidebar.addAttribute(new ClassAttribute("container-fluid sidebar visible-desktop"));
		UlTag ul = new UlTag();
		ul.addAttribute(new ClassAttribute("nav nav-sidebar"));
		
		LiTag li = new LiTag();
		ATag link= new ATag();
		link.addAttribute(new HREFAttribute(""));
		link.addChild(new Text("Nav item"));
		li.addChild(link);
		
		ul.addChild(li);
		
		LiTag li2 = new LiTag();
		ATag link2= new ATag();
		link2.addAttribute(new HREFAttribute(""));
		link2.addChild(new Text("Nav item"));
		li2.addChild(link2);
		
		ul.addChild(li2);
		
		LiTag li3 = new LiTag();
		ATag link3= new ATag();
		link3.addAttribute(new HREFAttribute(""));
		link3.addChild(new Text("Nav item"));
		li3.addChild(link3);
		
		ul.addChild(li3);
		
		LiTag li21 = new LiTag();
		ATag link21= new ATag();
		link21.addAttribute(new HREFAttribute(""));
		link21.addChild(new Text("Nav item"));
		li21.addChild(link21);
		
		ul.addChild(li21);
		sidebar.addChild(ul);
		
		return sidebar;
	}

}
