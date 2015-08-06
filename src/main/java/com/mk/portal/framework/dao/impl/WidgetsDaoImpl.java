package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.dao.WidgetsDao;
import com.mk.portal.framework.entity.WidgetEntity;
import com.mk.portal.framework.entity.WidgetInstanceEntity;
import com.mk.portal.framework.exceptions.PotentialBugException;
import com.mk.portal.framework.model.PageWidget;

public class WidgetsDaoImpl implements WidgetsDao {

	
	@Override
	public List<PageWidget> findWidgetsForPage(String pageId) {

		List<WidgetInstanceEntity> widgetPageMapping = new ArrayList<WidgetInstanceEntity>();
		List<String> listOfParams= new ArrayList<String>();
		listOfParams.add(pageId);
		widgetPageMapping = new QueryDao<WidgetInstanceEntity>().findListByQuery("from WidgetInstanceEntity where pageId=? ", listOfParams);
		
		
		return convertToPageWidgetList(widgetPageMapping);
	}

	private List<PageWidget> convertToPageWidgetList(
			List<WidgetInstanceEntity> widgetPageMapping) {
		List<PageWidget> widgets = new ArrayList<PageWidget>();
		for(WidgetInstanceEntity w:widgetPageMapping){
			PageWidget pw= new PageWidget();
			pw.setWidgetId(w.getWidgetId());
			pw.setPageId(w.getPageId());
			pw.setPageArea(w.getArea());
			pw.setAreaOrder(w.getOrder());
			List<WidgetEntity> widgetEntityList = new ArrayList<WidgetEntity>();
			WidgetEntity widget=null;
			List<String> listOfParams= new ArrayList<String>();
			listOfParams.add(w.getWidgetId());
			widgetEntityList =  new QueryDao<WidgetEntity>().findListByQuery("from WidgetEntity m where id=? ", listOfParams);
			if(widgetEntityList.size()==1){
				widget=widgetEntityList.get(0);
			}
			else{
				throw new PotentialBugException("data issue", "data setup issue");
			}
			pw.setName(widget.getName());
			pw.setTitle(widget.getTitle());
			widgets.add(pw);
		}
		return widgets;
	}

}