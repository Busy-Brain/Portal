package com.mk.portal.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.html.objects.Attribute;
import com.mk.portal.framework.html.objects.HTMLVersion;
import com.mk.portal.framework.html.objects.Page;
import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.html.objects.Tag;
import com.mk.portal.framework.html.objects.TagComponent;
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

public class PageDetailsServiceImpl implements PageDetailsService {

	public Page getpage(PageIdentifier pageId) {
		List<PageComponent> pageComponents = new ArrayList<PageComponent>();
		pageComponents.add(getDoctype());
		PageComponent htmlTag = getHTMLTag();
		pageComponents.add(htmlTag);
		htmlTag.addChild(getHeadTag());
		htmlTag.addChild(getBodyTag());
		return new Page(pageComponents);
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

	private DocTypeDeclaration getDoctype() {
		// TODO read from properties, defaulted to HTML5
		return new DocTypeDeclaration(HTMLVersion.HTML_5);
	}

	private Tag getHTMLTag() {
		Tag html = new HTMLTag();
		// TODO make it dynamic
		Attribute languageAttribute = new LangAttribute("en");
		html.addAttribute(languageAttribute);
		return html;
	}

	private Tag getHeadTag() {
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
		List<LinkTag> cssList=getLayout().getCss();
		for(LinkTag css:cssList){
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
