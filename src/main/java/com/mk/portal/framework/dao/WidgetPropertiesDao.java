package com.mk.portal.framework.dao;

import java.util.List;

import com.mk.portal.framework.entity.WidgetPropertyEntity;

public interface WidgetPropertiesDao {

	List<WidgetPropertyEntity> findByWidgetId(String widgetId);

}
