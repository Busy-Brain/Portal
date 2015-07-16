package com.mk.portal.framework.dao;

import java.util.List;

import com.mk.portal.framework.model.PageWidget;
/**
 * UserDAO has database related operations for Portal User
 * @author mohit
 *
 */
public interface WidgetsDao {

	List<PageWidget> findWidgetsForPage(String pageId);

}