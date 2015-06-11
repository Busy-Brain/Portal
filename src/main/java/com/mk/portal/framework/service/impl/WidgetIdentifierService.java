package com.mk.portal.framework.service.impl;

import com.mk.portal.framework.service.PortalService;
import com.mk.portal.framework.service.PortalVO;
import com.mk.portal.framework.service.ServiceResponse;
import com.mk.portal.framework.widget.WidgetServiceResponse;
import com.mk.portal.framework.widget.WidgetServiceVO;



public class WidgetIdentifierService implements PortalService {

	public ServiceResponse execute(WidgetServiceVO vo) {
		WidgetServiceResponse res= new WidgetServiceResponse();
		res.setServiceInput(vo);
		
		WidgetServiceVO serviceResponse=getWidgetByName(vo.getWidgetName());
		res.setServiceResponse(serviceResponse);
		//TODO res status can be false too
		res.setStatus(true);
		
		return res;
	}

	private WidgetServiceVO getWidgetByName(String widgetName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ServiceResponse execute(PortalVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public PortalVO getEmptyInputVo() {
		// TODO Auto-generated method stub
		return null;
	}

}
