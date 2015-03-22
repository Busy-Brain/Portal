package com.mk.portal.framework.widget;

import com.mk.portal.framework.service.PortalVO;
import com.mk.portal.framework.service.ServiceResponse;

public class WidgetServiceResponse implements ServiceResponse{
	
	private WidgetServiceVO serviceInput;
	private WidgetServiceVO serviceResponse;
	private boolean status;
	
	public PortalVO getServiceInput() {
		return serviceInput;
	}

	public PortalVO getServiceResponseVO() {
		return serviceResponse;
	}

	public boolean isExecutedSuccessfully() {
		return status;
	}

	public WidgetServiceVO getServiceResponse() {
		return serviceResponse;
	}

	public void setServiceResponse(WidgetServiceVO serviceResponse) {
		this.serviceResponse = serviceResponse;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setServiceInput(WidgetServiceVO serviceInput) {
		this.serviceInput = serviceInput;
	}

}
