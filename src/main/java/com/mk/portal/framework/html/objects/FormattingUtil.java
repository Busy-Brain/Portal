package com.mk.portal.framework.html.objects;

public class FormattingUtil {
	public static final String getFormattingTabs(int count){
		StringBuffer sb= new StringBuffer();
		for(int i=0;i<count;i++){
			sb.append("\t");
		}
		return sb.toString();
	}
}
