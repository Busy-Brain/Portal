package com.mk.portal.framework.page.html.layouts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mk.portal.framework.exceptions.PotentialBugException;
import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.attributes.GenericAttribute;
import com.mk.portal.framework.page.html.attributes.HREFAttribute;
import com.mk.portal.framework.page.html.attributes.IdAttribute;
import com.mk.portal.framework.page.html.attributes.RelAttribute;
import com.mk.portal.framework.page.html.attributes.TypeAttribute;
import com.mk.portal.framework.page.html.tags.ATag;
import com.mk.portal.framework.page.html.tags.ButtonTag;
import com.mk.portal.framework.page.html.tags.DivTag;
import com.mk.portal.framework.page.html.tags.LiTag;
import com.mk.portal.framework.page.html.tags.LinkTag;
import com.mk.portal.framework.page.html.tags.NavTag;
import com.mk.portal.framework.page.html.tags.SpanTag;
import com.mk.portal.framework.page.html.tags.Text;
import com.mk.portal.framework.page.html.tags.UlTag;

public class LeftNavBarLayout extends Layout {

	
	private Map<String, ArrayList<PageComponent>> areas=new HashMap<String, ArrayList<PageComponent>>();

	

	@Override
	protected TagComponent getComponent() {
		DivTag layout = new DivTag();

		NavTag nav = new NavTag();
		nav.addAttribute(new ClassAttribute(
				"navbar navbar-inverse navbar-fixed-top header"));
		nav.addAttribute(new GenericAttribute("role", "navigation"));

		DivTag div = new DivTag();
		div.addAttribute(new ClassAttribute("container-fluid header"));
		nav.addChild(div);

		DivTag navHeader = new DivTag();
		navHeader.addAttribute(new ClassAttribute("navbar-header"));
		div.addChild(navHeader);

		ButtonTag button = new ButtonTag();
		button.addAttribute(new ClassAttribute("navbar-toggle collapsed"));
		button.addAttribute(new TypeAttribute("button"));
		button.addAttribute(new GenericAttribute("data-toggle", "collapse"));
		button.addAttribute(new GenericAttribute("data-target", "#navbar"));
		button.addAttribute(new GenericAttribute("aria-expanded", "false"));
		button.addAttribute(new GenericAttribute("aria-controls", "navbar"));
		navHeader.addChild(button);
		SpanTag srOnly = new SpanTag();
		srOnly.addAttribute(new ClassAttribute("sr-only"));
		srOnly.addChild(new Text("Toggle navigation"));
		button.addChild(srOnly);
		SpanTag iconBar = new SpanTag();
		iconBar.addAttribute(new ClassAttribute("icon-bar"));
		button.addChild(iconBar);
		button.addChild(iconBar);
		button.addChild(iconBar);

		ATag a = new ATag();
		a.addAttribute(new ClassAttribute("navbar-brand"));
		a.addAttribute(new HREFAttribute("#"));
		a.addChild(new Text("Me!"));
		navHeader.addChild(a);
		DivTag navbar = new DivTag();
		div.addChild(navbar);
		navbar.addAttribute(new IdAttribute("navbar"));
		navbar.addAttribute(new ClassAttribute("navbar-collapse collapse "));
		
		List<PageComponent> topBarList=getComponentsFromArea("0");
		if(topBarList!=null){
			for(PageComponent c:topBarList){
				navbar.addChild(c);
			}
		}
		DivTag containerfluid = new DivTag();
		containerfluid.addAttribute(new ClassAttribute("container"));
		DivTag row = new DivTag();
		containerfluid.addChild(row);
		row.addAttribute(new ClassAttribute("row  main"));
		DivTag navBar = new DivTag();
		navBar.addAttribute(new ClassAttribute("col-md-3"));
		DivTag mainBody = new DivTag();
		mainBody.addAttribute(new ClassAttribute("col-md-12"));
		row.addChild(navBar);
		row.addChild(mainBody);
		List<PageComponent> leftbarList=getComponentsFromArea("1");
		if(leftbarList!=null){
			for(PageComponent c:leftbarList){
				navBar.addChild(c);
			}
		}
		List<PageComponent> mainBodyList=getComponentsFromArea("2");
		if(mainBodyList!=null){
			for(PageComponent c:mainBodyList){
				mainBody.addChild(c);
			}
		}
		
		
		
		layout.addChild(nav);
		layout.addChild(containerfluid);
		return layout;
	}

	public List<LinkTag> getCss() {
		List<LinkTag> css= new ArrayList<LinkTag>();
		LinkTag dashboardCSS = new LinkTag();
		dashboardCSS.addAttribute(new HREFAttribute(
				"/qbank/static/css/default/dashboard.css"));
		dashboardCSS.addAttribute(new RelAttribute("stylesheet"));
		css.add(dashboardCSS);
		return css;
	}

	public List<PageComponent> getScript() {
		return new ArrayList<PageComponent>();

	}

	@Override
	public int getAreaCount() {
		return 3;
	}

	@Override
	public boolean setComponentInArea(PageComponent component, String areaPosition) {
		
		ArrayList<PageComponent> area;
		if(areas.get(areaPosition) == null){
			area=new ArrayList<PageComponent>();
			areas.put(areaPosition, area);
		}
		else{
			area=areas.get(areaPosition);
		}
		return area.add(component);
		
	}

	@Override
	public List<PageComponent> getComponentsFromArea(String area) {
		return areas.get(area);
	}
}
