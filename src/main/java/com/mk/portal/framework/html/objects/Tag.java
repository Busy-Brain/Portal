package com.mk.portal.framework.html.objects;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.model.PortalPage;

public abstract class Tag implements TagComponent {
	private List<Attribute> attributes;
	@Override
	public PortalPage getPage() {
		return page;
	}
	public void setPage(PortalPage page) {
		this.page = page;
	}
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	public void setChildren(List<PageComponent> children) {
		this.children = children;
	}


	private List<PageComponent> children;
	private PortalPage page;

	public List<PageComponent> getChildren() {
		return children;
	}
	public void addChild(PageComponent child) {
		//check for allowed children
		if (this.children == null) {
			this.children = new ArrayList<PageComponent>();
		}
		if (child != null) {
			this.children.add(child);
		}

	}

	public List<Attribute> getAttributes() {
		return attributes;
	}
	public void addAttribute(Attribute attribute) {
		if (attributes == null) {
			attributes = new ArrayList<Attribute>();
		}
		if (attribute != null) {
			attributes.add(attribute);
		}
	}

	public TagComponent clone() {
		try {
			return (TagComponent) super.clone();
		} catch (CloneNotSupportedException e) {
			// can never happen
			throw new AssertionError();
		}
	}

	public boolean hasChildren() {
		return !((getChildren() == null) || (getChildren().size() == 0));
	}

	public String getStartTag() {
		// begin start tag
		StringBuffer tag = new StringBuffer("<" + getTagName());
		// add all attributes
		if (getAttributes() != null) {
			for (Attribute attribute : getAttributes()) {
				tag.append(" ");
				tag.append(attribute.getName());
				tag.append("=");
				tag.append("\""+attribute.getValue()+"\"");
			}
		}
		// close start tag
		if (hasEndTag() || hasChildren()) {
			tag.append(">");
		} else {
			tag.append("/>");
		}
		return tag.toString();
	}

	public String getEndTag() {
		// begin start tag
		StringBuffer tag = new StringBuffer("</" + getTagName() + ">");

		return tag.toString();
	}

	@Override
	public String toString() {
		// begin start tag
		StringBuffer tag = new StringBuffer(getStartTag());

		if (hasChildren()) {
			for (PageComponent child : getChildren()) {
				tag.append(child.toString());
			}
		}
		if (hasEndTag()) {
			tag.append(getEndTag());
		}
		return tag.toString();
	}
	

	public String toFormattedString(int tabCount) {
		// begin start tag
		StringBuffer tag = new StringBuffer();
		tag.append(FormattingUtil.getFormattingTabs(tabCount)+getStartTag());
		

		if (hasChildren()) {
			for (PageComponent child : getChildren()) {
				tag.append("\n"+child.toFormattedString(tabCount+1));
			}
		}
		if (hasEndTag()) {
			if(hasChildren()){
				tag.append("\n"+FormattingUtil.getFormattingTabs(tabCount));
			}
			tag.append(getEndTag());
			
		}
		return tag.toString();
	}
	
}
