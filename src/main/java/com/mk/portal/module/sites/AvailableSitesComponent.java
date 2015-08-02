package com.mk.portal.module.sites;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.html.objects.AbstractComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.model.PortalSite;
import com.mk.portal.framework.page.html.attributes.HrefAttribute;
import com.mk.portal.framework.page.html.components.PageHeaderComponent;
import com.mk.portal.framework.page.html.components.TableComponent;
import com.mk.portal.framework.page.html.tags.ATag;
import com.mk.portal.framework.page.html.tags.DivTag;
import com.mk.portal.framework.page.html.tags.TdTag;
import com.mk.portal.framework.page.html.tags.Text;
import com.mk.portal.framework.page.html.tags.TrTag;
import com.mk.portal.framework.service.SiteDetailsService;

public class AvailableSitesComponent extends AbstractComponent{
	@Autowired
	private SiteDetailsService siteDetailsService ;
	
	public SiteDetailsService getSiteDetailsService() {
		return siteDetailsService;
	}

	public void setSiteDetailsService(SiteDetailsService siteDetailsService) {
		this.siteDetailsService = siteDetailsService;
	}

	@Override
	protected TagComponent getComponent() {
		DivTag component= new DivTag();
		component.addChild(new PageHeaderComponent("Available Sites"));
		TableComponent table = new TableComponent();
		PortalSite p = new PortalSite();
		table.addHeaders("Site Id","Site Name","Site Title","");
		List<PortalSite> listOfSites=siteDetailsService.getAccessibleSites();
		for(PortalSite site:listOfSites){
			TrTag tr = new TrTag();
			
			TdTag siteId=new TdTag();
			siteId.addChild(new Text(site.getSiteId()));
			tr.addChild(siteId);
			
			TdTag siteName=new TdTag();
			siteName.addChild(new Text(site.getSiteName()));
			tr.addChild(siteName);

			TdTag siteTitle=new TdTag();
			siteTitle.addChild(new Text(site.getSiteTitle()));
			tr.addChild(siteTitle);
			
			ATag a = new ATag();
			a.addChild(new Text("Details"));
			a.addAttribute(new HrefAttribute("/qbank/site/details?siteId="+site.getSiteId()));
			
			TdTag editLink=new TdTag();
			editLink.addChild(a);
			tr.addChild(editLink);
			table.addRows(tr);
		}
		
		component.addChild(table);
		
		return component;
	}

}
