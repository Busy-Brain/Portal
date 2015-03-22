package com.mk.portal.framework.service.impl;

import com.mk.portal.framework.exceptions.PortalServiceException;
import com.mk.portal.framework.service.PortalService;
import com.mk.portal.framework.service.ServiceResponse;
import com.mk.portal.framework.widget.WidgetServiceResponse;
import com.mk.portal.framework.widget.WidgetServiceVO;



public class WidgetIdentifierService implements PortalService<WidgetServiceVO, ServiceResponse> {

	public ServiceResponse execute(WidgetServiceVO vo) {
		WidgetServiceResponse res= new WidgetServiceResponse();
		res.setServiceInput(vo);
		try{
		WidgetServiceVO serviceResponse=getWidgetByName(vo.getWidgetName());
		res.setServiceResponse(serviceResponse);
		
		res.setStatus(true);
		}
		catch(PortalServiceException e){
			res.setStatus(false);
		}
		return res;
	}

	private WidgetServiceVO getWidgetByName(String widgetName) throws PortalServiceException{
		// TODO Auto-generated method stub
		return null;
	}

}
