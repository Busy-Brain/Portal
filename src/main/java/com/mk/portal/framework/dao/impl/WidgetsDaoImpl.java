package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.WidgetsDao;
import com.mk.portal.framework.entity.WidgetEntity;
import com.mk.portal.framework.entity.WidgetPageMappingEntity;
import com.mk.portal.framework.exceptions.PotentialBugException;
import com.mk.portal.framework.model.PageWidget;

public class WidgetsDaoImpl implements WidgetsDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	


	@SuppressWarnings("unchecked")
	@Override
	public List<PageWidget> findWidgetsForPage(String pageId) {

		List<WidgetPageMappingEntity> widgetPageMapping = new ArrayList<WidgetPageMappingEntity>();
		Session session = getSessionFactory().openSession();
	
		widgetPageMapping = session.createQuery("from WidgetPageMappingEntity m where pageId=? ").setParameter(0, pageId).list();
		
		session.close();
		
		return convertToPageWidgetList(widgetPageMapping);
	}

	@SuppressWarnings("unchecked")
	private List<PageWidget> convertToPageWidgetList(
			List<WidgetPageMappingEntity> widgetPageMapping) {
		List<PageWidget> widgets = new ArrayList<PageWidget>();
		for(WidgetPageMappingEntity w:widgetPageMapping){
			PageWidget pw= new PageWidget();
			pw.setWidgetId(w.getWidgetId());
			pw.setPageId(w.getPageId());
			pw.setPageArea(w.getArea());
			pw.setAreaOrder(w.getOrder());
			List<WidgetEntity> widgetEntityList = new ArrayList<WidgetEntity>();
			Session session = getSessionFactory().openSession();
			WidgetEntity widget=null;
			widgetEntityList = session.createQuery("from WidgetEntity m where id=? ").setParameter(0, w.getWidgetId()).list();
			if(widgetEntityList.size()==1){
				widget=widgetEntityList.get(0);
			}
			else{
				throw new PotentialBugException("data issue", "data setup issue");
			}
			pw.setName(widget.getName());
			pw.setTitle(widget.getTitle());
			pw.setUiPath(widget.getUiPath());
			widgets.add(pw);
			session.close();
		}
		return widgets;
	}

}