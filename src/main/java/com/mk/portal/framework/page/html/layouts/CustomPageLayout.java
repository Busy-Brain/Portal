package com.mk.portal.framework.page.html.layouts;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.exceptions.BusinessException;
import com.mk.portal.framework.html.objects.AbstractComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.tags.DivTag;

public class CustomPageLayout extends AbstractComponent {
	private List<RowComponent> rows=new ArrayList<RowComponent>();
	
	public CustomPageLayout(int rowCount,int[]colsInEachRow) throws BusinessException{
		if(colsInEachRow.length==rowCount){
			for(int i=0;i<rowCount;i++){
				RowComponent row= new RowComponent();
				int colCount=colsInEachRow[i];
				if(colCount<1){
					throw new BusinessException("NO-COL-IN-ROW", "Please add at least 1 column");
				}
				else if(colCount>12){
					throw new BusinessException("COLS-MORE-THAN-CAPACITY", "Please add only 12 columns max");
				}
				for(int j=0;j<colCount;j++){
					ColumnComponent col = new ColumnComponent(1);
					row.addChild(col);
				}
				rows.add(row);
			}
		}
		else{
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	protected TagComponent getComponent() {
		DivTag div = new DivTag();
		div.addAttribute(new ClassAttribute("container-fluid"));
		for(RowComponent row:rows){
			div.addChild(row);
		}
		return div;
	}

}
