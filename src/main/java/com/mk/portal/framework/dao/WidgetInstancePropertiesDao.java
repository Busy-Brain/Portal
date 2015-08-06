package com.mk.portal.framework.dao;

import java.util.List;

import com.mk.portal.framework.entity.WidgetInstancePropertyEntity;
import com.mk.portal.framework.entity.WidgetPropertyEntity;

public interface WidgetInstancePropertiesDao {

	List<WidgetInstancePropertyEntity> findByWidgetInstanceId(String widgetId);

}
