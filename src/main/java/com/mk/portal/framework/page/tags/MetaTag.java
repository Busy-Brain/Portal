package com.mk.portal.framework.page.tags;


public class MetaTag extends PageSpecificPortalTag {

	@Override
	protected String getTagHTML() {
		return getSiteMetaTags().append(getTopicMetaTags()).append(getPageSpecificMetaTags()).toString();
	}

	private StringBuilder getPageSpecificMetaTags() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(new MetaTagObject("description", "text"));
		sb.append(new MetaTagObject("keywords", "word1,word2"));
		System.out.println(getPageIdentifier());
		return sb;
	}

	private StringBuilder getTopicMetaTags() {
		StringBuilder sb = new StringBuilder();
		sb.append(new MetaTagObject("revisit-after", "1 month"));
		return sb;
	}

	private StringBuilder getSiteMetaTags() {
		StringBuilder sb = new StringBuilder();
		sb.append(new SpecialMetaTagObject("charset","UTF-8"));
		sb.append(new MetaTagObject("robots", "index, follow"));
		return sb;
	}


}