package com.mk.portal.framework.html.objects;


public enum HTMLVersion {
	
	HTML_5(Constants.HTML_5,Constants.HTML_5_DECLARATION),
	HTML_4_01_Strict(Constants.HTML_4_01_STRICT,Constants.HTML_4_01_STRICT_DECLARATION),
	HTML_4_01_Transitional(Constants.HTML_4_01_TRANSITIONAL,Constants.HTML_4_01_TRANSITIONAL_DECLARATION),
	HTML_4_01_Frameset(Constants.HTML_4_01_FRAMESET,Constants.HTML_4_01_FRAMESET_DECLARATION),
	XHTML_1_0_Strict(Constants.XHTML_1_0_STRICT,Constants.XHTML_1_0_STRICT_DECLARATION),
	XHTML_1_0_Transitional(Constants.XHTML_1_0_TRANSITIONAL,Constants.XHTML_1_0_TRANSITIONAL_DECLARATION),
	XHTML_1_0_Frameset(Constants.XHTML_1_0_FRAMESET,Constants.XHTML_1_0_FRAMESET_DECLARATION),
	XHTML_1_1(Constants.XHTML_1_1,Constants.XHTML_1_1_DECLARATION);
	
	private String name;
	private String doctype;

	
	
	public String getDoctype() {
		return doctype;
	}

	private void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	private HTMLVersion(String name,String declaration){
		this.setName(name);
		this.setDoctype(declaration);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
}
