package com.mk.portal.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.html.objects.Attribute;
import com.mk.portal.framework.html.objects.HTMLVersion;
import com.mk.portal.framework.html.objects.Page;
import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.html.objects.Tag;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.model.PortalSite;
import com.mk.portal.framework.page.PageIdentifier;
import com.mk.portal.framework.page.html.attributes.HREFAttribute;
import com.mk.portal.framework.page.html.attributes.LangAttribute;
import com.mk.portal.framework.page.html.attributes.RelAttribute;
import com.mk.portal.framework.page.html.attributes.SrcAttribute;
import com.mk.portal.framework.page.html.components.MetaTagListComponent;
import com.mk.portal.framework.page.html.components.SideBarComponent;
import com.mk.portal.framework.page.html.layouts.LeftNavBarLayout;
import com.mk.portal.framework.page.html.tags.BodyTag;
import com.mk.portal.framework.page.html.tags.DocTypeDeclaration;
import com.mk.portal.framework.page.html.tags.HTMLTag;
import com.mk.portal.framework.page.html.tags.HeadTag;
import com.mk.portal.framework.page.html.tags.LinkTag;
import com.mk.portal.framework.page.html.tags.ScriptTag;
import com.mk.portal.framework.page.html.tags.Text;
import com.mk.portal.framework.page.html.tags.TitleTag;
import com.mk.portal.framework.service.PageDetailsService;
import com.mk.portal.framework.service.SiteDetailsService;

public class PageDetailsServiceImpl implements PageDetailsService {
	@Autowired
	private SiteDetailsService siteDetailsService;

	public Page getpage(PageIdentifier pageIdentifier) {
		PortalSite site=siteDetailsService.getSiteByUrl(pageIdentifier.getSiteUrl());
		if(site!=null){
			List<PageComponent> pageComponents = new ArrayList<PageComponent>();
			pageComponents.add(getDoctype(site.getHTMLVersion()));
			PageComponent htmlTag = getHTMLTag(pageIdentifier.getLanguage());
			pageComponents.add(htmlTag);
			htmlTag.addChild(getHeadTag(site.getSiteId()));
			htmlTag.addChild(getBodyTag());
			return new Page(pageComponents);
		}
		return getErrorPage();
	}

	private Page getErrorPage() {
		List<PageComponent> pageComponents = new ArrayList<PageComponent>();
		Page p = new Page(pageComponents );
		pageComponents.add(getDoctype(HTMLVersion.HTML_5.name()));
		PageComponent htmlTag = getHTMLTag("en");
		pageComponents.add(htmlTag);
		BodyTag body = new BodyTag();
		LeftNavBarLayout layout = null;
		layout = getLayout();
		layout.setMainBody(new Text("Unfortunately the page does not exists!"));
		body.addChild((PageComponent) layout);
		htmlTag.addChild(body);
		return p;
	}

	private PageComponent getBodyTag() {
		BodyTag body = new BodyTag();
		LeftNavBarLayout layout = null;
		layout = getLayout();
		layout.setLeftBar(new SideBarComponent());
		layout.setMainBody(new Text("This is Main Bodty"));
		body.addChild((PageComponent) layout);

		ScriptTag jq = new ScriptTag();
		jq.addAttribute(new SrcAttribute(
				"/qbank/static/js/default/jquery.min.js"));

		ScriptTag bs = new ScriptTag();
		bs.addAttribute(new SrcAttribute(
				"/qbank/static/js/default/bootstrap.min.js"));
		body.addChild(jq);
		body.addChild(bs);
		return body;
	}

	private LeftNavBarLayout getLayout() {
		return new LeftNavBarLayout();
	}

	private DocTypeDeclaration getDoctype(String htmlVersion) {
		return new DocTypeDeclaration(HTMLVersion.valueOf(htmlVersion));
	}

	private Tag getHTMLTag(String language) {
		Tag html = new HTMLTag();
		Attribute languageAttribute = new LangAttribute(language);
		html.addAttribute(languageAttribute);
		return html;
	}

	private Tag getHeadTag(String siteId) {
		Tag head = new HeadTag();
		populateMetaTags(head);
		head.addChild(getTitleTag());

		LinkTag boots = new LinkTag();
		boots.addAttribute(new HREFAttribute(
				"/qbank/static/css/default/bootstrap.min.css"));
		boots.addAttribute(new RelAttribute("stylesheet"));

		LinkTag cust = new LinkTag();
		cust.addAttribute(new HREFAttribute(
				"/qbank/static/css/default/style.css"));
		cust.addAttribute(new RelAttribute("stylesheet"));
		head.addChild(boots);
		List<LinkTag> cssList = getLayout().getCss();
		for (LinkTag css : cssList) {
			head.addChild(css);
		}

		head.addChild(cust);
		return head;
	}

	private void populateMetaTags(Tag head) {
		head.addChild(new MetaTagListComponent());
	}

	private TagComponent getTitleTag() {
		Tag title = new TitleTag();
		title.addChild(new Text("Mohit Kanwar - Keep Learning"));
		return title;
	}

}
