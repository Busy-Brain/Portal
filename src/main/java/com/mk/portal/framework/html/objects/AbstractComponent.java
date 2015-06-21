package com.mk.portal.framework.html.objects;

import java.util.List;

public abstract class AbstractComponent implements PageComponent{
	
	protected abstract TagComponent getComponent();
	@Override
	public PageComponent clone() {
		try {
			return (TagComponent) super.clone();
		} catch (CloneNotSupportedException e) {
			// can never happen
			throw new AssertionError();
		}
	}
	

	@Override
	public boolean hasChildren() {
		return !((getChildren() == null) || (getChildren().size() == 0));
	}
	

	@Override
	public List<PageComponent> getChildren() {
		return getComponent().getChildren();
	}

	@Override
	public void addChild(PageComponent child) {
		getComponent().addChild(child);

	}

	@Override
	public String toFormattedString(int tabCount) {
		// begin start tag
		StringBuffer tag = new StringBuffer();
		tag.append(FormattingUtil.getFormattingTabs(tabCount) + getComponent().getStartTag());

		if (hasChildren()) {
			for (PageComponent child : getChildren()) {
				tag.append("\n" + child.toFormattedString(tabCount + 1));
			}
		}
		if (getComponent().hasEndTag()) {
			if (hasChildren()) {
				tag.append("\n" + FormattingUtil.getFormattingTabs(tabCount));
			}
			tag.append(getComponent().getEndTag());

		}
		return tag.toString();
	}
	@Override
	public String toString() {
		return getComponent().toString();
	}
}
