package com.mk.portal.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.PageDao;
import com.mk.portal.framework.html.objects.Attribute;
import com.mk.portal.framework.html.objects.HTMLVersion;
import com.mk.portal.framework.html.objects.Page;
import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.html.objects.Tag;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.model.PageFileMapping;
import com.mk.portal.framework.model.PortalPage;
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
import com.mk.portal.framework.service.FileService;
import com.mk.portal.framework.service.PageDetailsService;
import com.mk.portal.framework.service.SiteDetailsService;

public class PageDetailsServiceImpl implements PageDetailsService {
	@Autowired
	private SiteDetailsService siteDetailsService;
	@Autowired
	PageDao pageDao;
	@Autowired
	private FileService fileService;
	
	public Page getpage(PageIdentifier pageIdentifier) {
		PortalSite site=siteDetailsService.getSiteByUrl(pageIdentifier.getSiteUrl());
		PortalPage page= pageDao.findBySiteId_PageUrl(site.getSiteId(), pageIdentifier.getpageUrl());
		if(page!=null){
			List<PageComponent> pageComponents = new ArrayList<PageComponent>();
			pageComponents.add(getDoctype(site.getHTMLVersion()));
			PageComponent htmlTag = getHTMLTag(pageIdentifier.getLanguage());
			pageComponents.add(htmlTag);
			List<PageFileMapping> files=fileService.findFilesForSiteAndPage(site.getSiteId(), page.getPageId());
			htmlTag.addChild(getHeadTag(site,page,files));
			htmlTag.addChild(getBodyTag(files));
			return new Page(pageComponents);
		}
		return getErrorPage(site.getSiteId());
	}

	private Page getErrorPage(String siteId) {
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

	private PageComponent getBodyTag(List<PageFileMapping> files) {
		BodyTag body = new BodyTag();
		LeftNavBarLayout layout = null;
		layout = getLayout();
		layout.setLeftBar(new SideBarComponent());
		layout.setMainBody(new Text("This is Main Bodty"));
		body.addChild((PageComponent) layout);

		
		for(PageFileMapping file:files){
			if(file.getFileType().equals("JS")){
				ScriptTag js = new ScriptTag();
				js.addAttribute(new SrcAttribute(
						file.getFilePath()));
				body.addChild(js);
			}
		}
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

	private Tag getHeadTag(PortalSite site, PortalPage page, List<PageFileMapping> files) {
		Tag head = new HeadTag();
		populateMetaTags(site,page,head);
		head.addChild(getTitleTag(page));
		for(PageFileMapping file:files){
			if(file.getFileType().equals("CSS")){
				LinkTag css = new LinkTag();
				css.addAttribute(new HREFAttribute(
						file.getFilePath()));
				css.addAttribute(new RelAttribute("stylesheet"));
				head.addChild(css);
			}
		}
				
		List<LinkTag> cssList = getLayout().getCss();
		for (LinkTag css : cssList) {
			head.addChild(css);
		}

		return head;
	}

	private void populateMetaTags(PortalSite site, PortalPage page, Tag head) {
		head.addChild(new MetaTagListComponent(site,page));
	}

	private TagComponent getTitleTag(PortalPage page) {
		Tag title = new TitleTag();
		title.addChild(new Text(page.getTitle()));
		return title;
	}

}
