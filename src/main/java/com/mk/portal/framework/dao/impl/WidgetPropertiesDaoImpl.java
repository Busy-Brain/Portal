package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.dao.WidgetPropertiesDao;
import com.mk.portal.framework.entity.WidgetPropertyEntity;

public class WidgetPropertiesDaoImpl implements WidgetPropertiesDao{
	
	private QueryDao<WidgetPropertyEntity> queryDao= new QueryDao<WidgetPropertyEntity>();

	@Override
	public List<WidgetPropertyEntity> findByWidgetId(String widgetId) {
		List<String> listOfParams=new ArrayList<String>();
		listOfParams.add(widgetId);
		List<WidgetPropertyEntity> widgetProperties = queryDao.findListByQuery("from WidgetPropertyEntity where widgetId=?", listOfParams);
		
		return widgetProperties;
	}
}
