package com.mk.portal.framework.service;

import com.mk.portal.framework.html.objects.Page;
import com.mk.portal.framework.page.PageIdentifier;
import com.mk.portal.framework.page.PortalPage;

public interface PageDetailsService {
public abstract Page getpage(PageIdentifier pageId); 
}
