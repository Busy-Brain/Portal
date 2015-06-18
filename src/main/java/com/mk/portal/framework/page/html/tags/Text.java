package com.mk.portal.framework.page.html.tags;

import java.util.List;

import com.mk.portal.framework.html.objects.FormattingUtil;
import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.html.objects.TagComponent;

public class Text implements PageComponent {
    private String value;
    private boolean bold;
    private boolean italics;
    private boolean underLined;
    private FontTag font;
	public Text(String string) {
		this.value=string;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
    @Override
    public String toString(){
    	StringBuffer sb = new StringBuffer();
    	if(isBold()){
    		sb.append("<strong>");
    	}
    	if(isItalics()){
    		sb.append("<i>");
    	}
    	if(isUnderLined()){
    		sb.append("<u>");
    	}
    	if(font!=null){
    		font.addChild(new Text(this.value));
    		sb.append(getFontString(0));
    	}
    	else{
    		sb.append(this.value);
    	}
    	
    	if(isUnderLined()){
    		sb.append("</u>");
    	}
    	if(isItalics()){
    		sb.append("</i>");
    	}
    	if(isBold()){
    		sb.append("</strong>");
    	}
    	return sb.toString();
    }

	private String getFontString(int tabCount) {
		if(tabCount>0){
			return font.toFormattedString(tabCount);
		}
		return font.toString();
	}

	@Override
	public TagComponent clone() {
		try {
			return (TagComponent) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new AssertionError();
		}
	}

	


	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public List<PageComponent> getChildren() {
		return null;
	}

	@Override
	public String toFormattedString(int tabcount) {
		return FormattingUtil.getFormattingTabs(tabcount)+this.toString();
	}

	@Override
	public void addChild(PageComponent child) {
		
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public boolean isItalics() {
		return italics;
	}

	public void setItalics(boolean italics) {
		this.italics = italics;
	}

	public boolean isUnderLined() {
		return underLined;
	}

	public void setUnderLined(boolean underLined) {
		this.underLined = underLined;
	}

	public FontTag getFont() {
		return font;
	}

	public void setFont(FontTag font) {
		this.font = font;
	}
}
