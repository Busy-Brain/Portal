package com.mk.portal.framework.page;

public class PageIdentifier {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pageUrl == null) ? 0 : pageUrl.hashCode());
		result = prime * result + ((siteUrl == null) ? 0 : siteUrl.hashCode());
		result = prime * result
				+ ((subTopicUrl == null) ? 0 : subTopicUrl.hashCode());
		result = prime * result + ((topicUrl == null) ? 0 : topicUrl.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageIdentifier other = (PageIdentifier) obj;
		if (pageUrl == null) {
			if (other.pageUrl != null)
				
				return false;
		} else if (!pageUrl.equals(other.pageUrl)){
			System.out.println("pageUrl "+pageUrl+" not eaual to "+other.pageUrl);
			return false;
		}
		if (siteUrl == null) {
			if (other.siteUrl != null)
				return false;
		} else if (!siteUrl.equals(other.siteUrl)){
			System.out.println("siteUrl "+siteUrl+" not eaual to "+other.siteUrl);
			return false;
		}
		if (subTopicUrl == null) {
			if (other.subTopicUrl != null)
				return false;
		} else if (!subTopicUrl.equals(other.subTopicUrl)){
			System.out.println("subtopicUrl "+subTopicUrl+" not eaual to "+other.subTopicUrl);
			return false;
		}
			
		if (topicUrl == null) {
			if (other.topicUrl != null)
				return false;
		} else if (!topicUrl.equals(other.topicUrl)){
			System.out.println("topicUrl "+topicUrl+" not eaual to "+other.topicUrl);
			return false;
		}
		return true;
	}
	private String siteUrl;
	private String subTopicUrl;
	private String topicUrl;
	private String pageUrl;
	private String language;
	public String getSiteUrl() {
		return siteUrl;
	}
	public void setSiteUrl(String pSiteUrl) {
		this.siteUrl = pSiteUrl;
	}
	public void setSubtopicUrl(String pSubTopicUrl) {
		this.subTopicUrl = pSubTopicUrl;
	}
	public void settopicUrl(String pTopicUrl) {
		this.topicUrl = pTopicUrl;
	}
	public void setpageUrl(String pPageUrl) {
		this.pageUrl = pPageUrl;
	}
	public PageIdentifier(String siteUrl,String topicUrl, String subtopicUrl, 
			String pageUrl) {
		super();
		this.siteUrl = siteUrl;
		this.subTopicUrl = subtopicUrl;
		this.topicUrl = topicUrl;
		this.pageUrl = pageUrl;
	}
	public String getSubtopicUrl() {
		return subTopicUrl;
	}
	public String gettopicUrl() {
		return topicUrl;
	}
	public String getpageUrl() {
		return pageUrl;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
