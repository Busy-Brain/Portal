package com.mk.portal.framework.service.impl;

import org.springframework.security.core.userdetails.UserDetails;

import com.mk.portal.framework.service.PortalVO;
import com.mk.portal.framework.service.ServiceResponse;

public class PortalUserServiceResponse implements ServiceResponse {
	private PortalUserDetailsVO portalUserDetailsVO;
	private PortalUserDetailsVO responseVO;
	private boolean status;

	public PortalUserServiceResponse(PortalUserDetailsVO vo,
			PortalUserDetailsVO presponseVO, boolean b) {
		portalUserDetailsVO = vo;
		responseVO = presponseVO;
		status = b;
	}

	public PortalVO getServiceInput() {
		return portalUserDetailsVO;
	}

	public PortalVO getServiceResponseVO() {
		return responseVO;
	}

	public boolean isExecutedSuccessfully() {
		return status;
	}

}
