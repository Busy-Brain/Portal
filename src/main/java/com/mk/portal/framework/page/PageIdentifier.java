package com.mk.portal.framework.page;

public class PageIdentifier {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pageId == null) ? 0 : pageId.hashCode());
		result = prime * result + ((siteId == null) ? 0 : siteId.hashCode());
		result = prime * result
				+ ((subTopicId == null) ? 0 : subTopicId.hashCode());
		result = prime * result + ((topicId == null) ? 0 : topicId.hashCode());
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
		if (pageId == null) {
			if (other.pageId != null)
				
				return false;
		} else if (!pageId.equals(other.pageId)){
			System.out.println("pageId "+pageId+" not eaual to "+other.pageId);
			return false;
		}
		if (siteId == null) {
			if (other.siteId != null)
				return false;
		} else if (!siteId.equals(other.siteId)){
			System.out.println("siteId "+siteId+" not eaual to "+other.siteId);
			return false;
		}
		if (subTopicId == null) {
			if (other.subTopicId != null)
				return false;
		} else if (!subTopicId.equals(other.subTopicId)){
			System.out.println("subTopicId "+subTopicId+" not eaual to "+other.subTopicId);
			return false;
		}
			
		if (topicId == null) {
			if (other.topicId != null)
				return false;
		} else if (!topicId.equals(other.topicId)){
			System.out.println("topicId "+topicId+" not eaual to "+other.topicId);
			return false;
		}
		return true;
	}
	private String siteId;
	private String subTopicId;
	private String topicId;
	private String pageId;
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public void setSubTopicId(String subTopicId) {
		this.subTopicId = subTopicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public PageIdentifier(String siteId,String topicId, String subTopicId, 
			String pageId) {
		super();
		this.siteId = siteId;
		this.subTopicId = subTopicId;
		this.topicId = topicId;
		this.pageId = pageId;
	}
	public String getSubTopicId() {
		return subTopicId;
	}
	public String getTopicId() {
		return topicId;
	}
	public String getPageId() {
		return pageId;
	}
}
