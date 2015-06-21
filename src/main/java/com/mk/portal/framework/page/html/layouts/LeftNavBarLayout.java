package com.mk.portal.framework.page.html.layouts;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.html.objects.AbstractComponent;
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

public class LeftNavBarLayout extends AbstractComponent {

	private PageComponent leftBar;
	private PageComponent mainBody;

	// private List<PageComponent> children = new ArrayList<PageComponent>();
	/*
	 * private String layoutTemplate="<div class='container-fluid'>"+
	 * "<div class='row-fluid'>"+ "<div class='span2'>"+ "{{widgetArea}}" +
	 * "</div>"+ "<div class='span10'>"+ "{{widgetArea}}" + "</div>"+ "</div>"+
	 * "</div>";
	 */

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
		UlTag topLinks = new UlTag();
		topLinks.addAttribute(new ClassAttribute("nav navbar-nav navbar-right"));
		navbar.addChild(topLinks);
		LiTag link1 = new LiTag();
		ATag a1 = new ATag();
		a1.addAttribute(new HREFAttribute("/qbank/logout"));
		a1.addChild(new Text("Logout"));
		link1.addChild(a1);
		topLinks.addChild(link1);
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
		navBar.addChild(getLeftBar());
		mainBody.addChild(getMainBody());
		layout.addChild(nav);
		layout.addChild(containerfluid);
		return layout;
	}

	public PageComponent getLeftBar() {
		return leftBar;
	}

	public void setLeftBar(PageComponent leftBar) {
		this.leftBar = leftBar;
	}

	public PageComponent getMainBody() {
		return mainBody;
	}

	public void setMainBody(PageComponent mainBody) {
		this.mainBody = mainBody;
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
}
