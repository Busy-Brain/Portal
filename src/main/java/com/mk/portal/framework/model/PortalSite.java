package com.mk.portal.framework.model;

import com.mk.portal.framework.page.PortalPage;


public class PortalSite {
	private SiteSEO siteSEO;
	private SiteUI siteUI;
	private PortalPage defaultPage;
	private String siteTitleId;
	private String siteId;
	private String siteName;
	public SiteSEO getSiteSEO() {
		return siteSEO;
	}
	public void setSiteSEO(SiteSEO siteSEO) {
		this.siteSEO = siteSEO;
	}
	public SiteUI getSiteUI() {
		return siteUI;
	}
	public void setSiteUI(SiteUI siteUI) {
		this.siteUI = siteUI;
	}
	public PortalPage getDefaultPage() {
		return defaultPage;
	}
	public void setDefaultPage(PortalPage defaultPage) {
		this.defaultPage = defaultPage;
	}
	public String getSiteTitle() {
		return siteTitleId;
	}
	public void setSiteTitle(String siteTitle) {
		this.siteTitleId = siteTitle;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
}
