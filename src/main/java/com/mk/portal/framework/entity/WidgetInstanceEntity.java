package com.mk.portal.framework.entity;
// Generated 24 Jul, 2015 2:29:11 PM by Hibernate Tools 3.2.2.GA



/**
 * WidgetInstanceEntity generated by hbm2java
 */
public class WidgetInstanceEntity  implements java.io.Serializable {


     private int id;
     private String widgetId;
     private String pageId;
     private String area;
     private int order;

    public WidgetInstanceEntity() {
    }

    public WidgetInstanceEntity(String widgetId, String pageId, String area, int order) {
       this.widgetId = widgetId;
       this.pageId = pageId;
       this.area = area;
       this.order = order;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getWidgetId() {
        return this.widgetId;
    }
    
    public void setWidgetId(String widgetId) {
        this.widgetId = widgetId;
    }
    public String getPageId() {
        return this.pageId;
    }
    
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
    public String getArea() {
        return this.area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
    public int getOrder() {
        return this.order;
    }
    
    public void setOrder(int order) {
        this.order = order;
    }




}


