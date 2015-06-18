package com.mk.portal.framework.page.html.tags;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.html.objects.Attribute;
import com.mk.portal.framework.html.objects.HTMLVersion;
import com.mk.portal.framework.html.objects.Tag;

/**
 * The <!DOCTYPE> declaration must be the very first thing in your HTML
 * document, before the <html> tag.
 * 
 * The <!DOCTYPE> declaration is not an HTML tag; it is an instruction to the
 * web browser about what version of HTML the page is written in.
 * 
 * In HTML 4.01, the <!DOCTYPE> declaration refers to a DTD, because HTML 4.01
 * was based on SGML. The DTD specifies the rules for the markup language, so
 * that the browsers render the content correctly.
 * 
 * HTML5 is not based on SGML, and therefore does not require a reference to a
 * DTD.
 * 
 * Tip: Always add the <!DOCTYPE> declaration to your HTML documents, so that
 * the browser knows what type of document to expect.
 * 
 * @author mohit
 *
 */
public class DocTypeDeclaration extends Tag {

	private HTMLVersion htmlVersion = null;
	
	public DocTypeDeclaration(){
		this.htmlVersion=HTMLVersion.HTML_5;
	}
	public DocTypeDeclaration(HTMLVersion phtmlVersion){
		this.htmlVersion=phtmlVersion;
	}
	
	@Override
	public List<Attribute> getAttributes() {
		return new ArrayList<Attribute>();
	}

	@Override
	public String getStartTag() {
		return htmlVersion.getDoctype();
	}

	@Override
	public boolean hasEndTag() {
		return false;
	}

	@Override
	public String getEndTag() {
		return null;
	}

	@Override
	public String toString() {
		
		return "<!"+getStartTag()+">";
	}
	@Override
	public String toFormattedString(int tabcount) {
		
		return "<!"+getStartTag()+">\n";
	}
	
	@Override
	public String getTagName() {
		return "DOCTYPE";
	}

}
