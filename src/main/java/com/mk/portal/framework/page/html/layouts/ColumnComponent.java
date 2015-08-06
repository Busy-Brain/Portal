package com.mk.portal.framework.page.html.layouts;

import com.mk.portal.framework.html.objects.AbstractTagComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.tags.DivTag;

public class ColumnComponent extends AbstractTagComponent{
	private String classAttributeValue;
	public ColumnComponent(int spanCount){
		if(spanCount<1){
			spanCount=1;
		}
		else if(spanCount>12){
			spanCount=12;
		}
		classAttributeValue="span"+spanCount;
	}

	@Override
	protected TagComponent getComponent() {
		DivTag column=new DivTag();
		column.addAttribute(new ClassAttribute(classAttributeValue));
		return column;
	}

}
