package com.mk.portal.framework.entity;

public class SiteEntity {
	private String siteId;
	private String siteName;
	private String siteTitle;
	private String siteTemplateId;
	private boolean enabled;
	
	public String getSiteTitle() {
		return siteTitle;
	}
	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
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
	public String getSiteTemplateId() {
		return siteTemplateId;
	}
	public void setSiteTemplateId(String siteTemplateId) {
		this.siteTemplateId = siteTemplateId;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
