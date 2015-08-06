package com.mk.portal.framework.html.objects;

import java.util.List;

import com.mk.portal.framework.model.PortalPage;

public abstract class AbstractTagComponent implements PageComponent{
	
	private PortalPage page;
	@Override
	public PortalPage getPage() {
		return page;
	}
	@Override
	public void setPage(PortalPage pageId) {
		this.page = pageId;
	}
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
		TagComponent component = getComponent();
		tag.append(FormattingUtil.getFormattingTabs(tabCount) + component.getStartTag());

		if (hasChildren()) {
			for (PageComponent child : getChildren()) {
				tag.append("\n" + child.toFormattedString(tabCount + 1));
			}
		}
		if (component.hasEndTag()) {
			if (hasChildren()) {
				tag.append("\n" + FormattingUtil.getFormattingTabs(tabCount));
			}
			tag.append(component.getEndTag());

		}
		return tag.toString();
	}
	@Override
	public String toString() {
		return getComponent().toString();
	}
}
