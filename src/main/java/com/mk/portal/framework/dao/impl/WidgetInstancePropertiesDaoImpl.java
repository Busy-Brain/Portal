package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.dao.WidgetInstancePropertiesDao;
import com.mk.portal.framework.entity.WidgetInstancePropertyEntity;

public class WidgetInstancePropertiesDaoImpl implements WidgetInstancePropertiesDao{
	
	private QueryDao<WidgetInstancePropertyEntity> queryDao= new QueryDao<WidgetInstancePropertyEntity>();

	

	@Override
	public List<WidgetInstancePropertyEntity> findByWidgetInstanceId(String widgetInstanceId) {
		List<String> listOfParams=new ArrayList<String>();
		listOfParams.add(widgetInstanceId);
		List<WidgetInstancePropertyEntity> widgetProperties = queryDao.findListByQuery("from WidgetInstancePropertyEntity where widgetInstanceId=?", listOfParams);
		
		return widgetProperties;
	}
}
