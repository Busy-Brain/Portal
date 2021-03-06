package com.mk.portal.framework.entity;
// Generated 6 Aug, 2015 5:39:58 PM by Hibernate Tools 3.2.2.GA



/**
 * PageEntity generated by hbm2java
 */
public class PageEntity  implements java.io.Serializable {


     private String pageId;
     private String siteId;
     private String pageTitle;
     private boolean enabled;
     private String pageLinkId;

    public PageEntity() {
    }

	
    public PageEntity(String pageId, String siteId, boolean enabled, String pageLinkId) {
        this.pageId = pageId;
        this.siteId = siteId;
        this.enabled = enabled;
        this.pageLinkId = pageLinkId;
    }
    public PageEntity(String pageId, String siteId, String pageTitle, boolean enabled, String pageLinkId) {
       this.pageId = pageId;
       this.siteId = siteId;
       this.pageTitle = pageTitle;
       this.enabled = enabled;
       this.pageLinkId = pageLinkId;
    }
   
    public String getPageId() {
        return this.pageId;
    }
    
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
    public String getSiteId() {
        return this.siteId;
    }
    
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getPageTitle() {
        return this.pageTitle;
    }
    
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public String getPageLinkId() {
        return this.pageLinkId;
    }
    
    public void setPageLinkId(String pageLinkId) {
        this.pageLinkId = pageLinkId;
    }




}


