package com.mk.portal.framework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mk.portal.framework.model.PortalLink;
import com.mk.portal.framework.service.LinksService;
import com.mk.portal.framework.service.SiteDetailsService;

@RestController
public class LinksController {
	@Autowired
	LinksService linksServiceImpl;
	@Autowired
	SiteDetailsService siteDetailsService;
	@RequestMapping("/api/{siteUrl}/toplinks/")
    public List<PortalLink> getTopLinks(@RequestParam(value="siteUrl") String siteUrl) {
		String siteId = siteDetailsService.getSiteByUrl(siteUrl).getSiteId();
		return linksServiceImpl.findTopLevelLinksForSite(siteId);
		
	}
}
