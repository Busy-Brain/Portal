package com.mk.portal.framework.page.html.components;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.html.objects.Attribute;
import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.model.PortalPage;
import com.mk.portal.framework.model.PortalSite;
import com.mk.portal.framework.page.html.attributes.CharsetAttribute;
import com.mk.portal.framework.page.html.attributes.ContentAttribute;
import com.mk.portal.framework.page.html.attributes.HttpequivAttribute;
import com.mk.portal.framework.page.html.attributes.NameAttribute;
import com.mk.portal.framework.page.html.tags.MetaTag;

public class MetaTagListComponent extends AbstractComponentList {
	private PortalSite site;
	private PortalPage page;

	public MetaTagListComponent(PortalSite site, PortalPage page) {
		this.site=site;
		this.page=page;
	}

	@Override
	protected List<PageComponent> getComponentList() {
		List<PageComponent> metaTagsList = new ArrayList<PageComponent>();
		metaTagsList.add(getViewPortMetaTag());
		metaTagsList.add(getGeneratorMetaTag());
		metaTagsList.add(getCharsetMetaTag(site));
		metaTagsList.add(getContentMetaTag(site));
		return metaTagsList;
	}

	private MetaTag getViewPortMetaTag() {
		MetaTag metaTag = new MetaTag();
		Attribute name = new NameAttribute("viewport");
		metaTag.addAttribute(name);
		Attribute content = new ContentAttribute(
				"width=device-width, initial-scale=1, maximum-scale=1");
		metaTag.addAttribute(content);
		return metaTag;
	}

	private MetaTag getGeneratorMetaTag() {
		MetaTag metaTag = new MetaTag();
		Attribute name = new NameAttribute("generator");
		metaTag.addAttribute(name);
		Attribute content = new ContentAttribute("Bootply");
		metaTag.addAttribute(content);
		return metaTag;
	}

	private MetaTag getCharsetMetaTag(PortalSite site) {
		MetaTag metaTag = new MetaTag();
		
		Attribute charset = new CharsetAttribute(site.getCharSet());
		metaTag.addAttribute(charset);
		return metaTag;
	}

	private MetaTag getContentMetaTag(PortalSite site) {
		MetaTag metaTag = new MetaTag();
		Attribute cont = new HttpequivAttribute("content-type");
		Attribute type = new ContentAttribute("text/html; charset="+site.getCharSet());
		metaTag.addAttribute(cont);
		metaTag.addAttribute(type);
		return metaTag;
	}
}
