package com.mk.portal.framework.page.html.components;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.html.objects.AbstractComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.tags.TableTag;
import com.mk.portal.framework.page.html.tags.TbodyTag;
import com.mk.portal.framework.page.html.tags.Text;
import com.mk.portal.framework.page.html.tags.ThTag;
import com.mk.portal.framework.page.html.tags.TheadTag;
import com.mk.portal.framework.page.html.tags.TrTag;

public class TableComponent extends AbstractComponent {
	
	private List<String> tableHeaders = new ArrayList<String>();
	public void addHeaders(String ...arg){
		for(String s :arg){
			tableHeaders.add(s);
		}
	}
	private List<TrTag> rows=new ArrayList<TrTag>();
	public void addRows(TrTag ...arg){
		for(TrTag s :arg){
			rows.add(s);
		}
	}
	@Override
	protected TagComponent getComponent() {

		TableTag table = new TableTag();
		table.addAttribute(new ClassAttribute("table"));
		TheadTag tableHeader = new TheadTag();
		table.addChild(tableHeader);
		TrTag tableHeaderRow = new TrTag();
		tableHeader.addChild(tableHeaderRow);

		for (String s : tableHeaders) {
			ThTag colName = new ThTag();
			colName.addChild(new Text(s));
			tableHeader.addChild(colName);
		}
		TbodyTag tableBody = new TbodyTag();
		for(TrTag row : rows){
			tableBody.addChild(row);
		}
		table.addChild(tableBody);
		return table;
	}

}
