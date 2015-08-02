package com.mk.portal.framework.service;

import com.mk.portal.framework.html.objects.Page;

public interface PageDetailsService {

	public abstract Page getpage(String url, String queryparam);
}
