package com.mk.portal.framework.page.html.tags;
import com.mk.portal.framework.html.objects.Tag;
import com.mk.portal.framework.page.html.attributes.AccesskeyAttribute;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.attributes.ContenteditableAttribute;
import com.mk.portal.framework.page.html.attributes.ContextmenuAttribute;
import com.mk.portal.framework.page.html.attributes.DirAttribute;
import com.mk.portal.framework.page.html.attributes.DraggableAttribute;
import com.mk.portal.framework.page.html.attributes.DropzoneAttribute;
import com.mk.portal.framework.page.html.attributes.HiddenAttribute;
import com.mk.portal.framework.page.html.attributes.IdAttribute;
import com.mk.portal.framework.page.html.attributes.LangAttribute;
import com.mk.portal.framework.page.html.attributes.SpellcheckAttribute;
import com.mk.portal.framework.page.html.attributes.StyleAttribute;
import com.mk.portal.framework.page.html.attributes.TabindexAttribute;
import com.mk.portal.framework.page.html.attributes.TitleAttribute;
import com.mk.portal.framework.page.html.attributes.TranslateAttribute;
public class DatalistTag extends Tag { 



	private AccesskeyAttribute accesskey;
	private ClassAttribute classAttribute;
	private ContenteditableAttribute contenteditable;
	private ContextmenuAttribute contextmenu;
	private DirAttribute dir;
	private DraggableAttribute draggable;
	private DropzoneAttribute dropzone;
	private HiddenAttribute hidden;
	private IdAttribute id;
	private LangAttribute lang;
	private SpellcheckAttribute spellcheck;
	private StyleAttribute style;
	private TabindexAttribute tabindex;
	private TitleAttribute title;
	private TranslateAttribute translate;
	@Override 
	public boolean hasEndTag() {
		return true;
	}
	@Override
	public String getTagName() {
		return "datalist";
	}

	public AccesskeyAttribute getAccesskeyAttribute() {
		return this.accesskey;
	}
	public void setAccesskeyAttribute(AccesskeyAttribute accesskey) {
		this.accesskey=accesskey;
	}
	public ClassAttribute getClassAttribute() {
		return this.classAttribute;
	}
	public void setClassAttribute(ClassAttribute classAttribute) {
		this.classAttribute=classAttribute;
	}
	public ContenteditableAttribute getContenteditableAttribute() {
		return this.contenteditable;
	}
	public void setContenteditableAttribute(ContenteditableAttribute contenteditable) {
		this.contenteditable=contenteditable;
	}
	public ContextmenuAttribute getContextmenuAttribute() {
		return this.contextmenu;
	}
	public void setContextmenuAttribute(ContextmenuAttribute contextmenu) {
		this.contextmenu=contextmenu;
	}
	public DirAttribute getDirAttribute() {
		return this.dir;
	}
	public void setDirAttribute(DirAttribute dir) {
		this.dir=dir;
	}
	public DraggableAttribute getDraggableAttribute() {
		return this.draggable;
	}
	public void setDraggableAttribute(DraggableAttribute draggable) {
		this.draggable=draggable;
	}
	public DropzoneAttribute getDropzoneAttribute() {
		return this.dropzone;
	}
	public void setDropzoneAttribute(DropzoneAttribute dropzone) {
		this.dropzone=dropzone;
	}
	public HiddenAttribute getHiddenAttribute() {
		return this.hidden;
	}
	public void setHiddenAttribute(HiddenAttribute hidden) {
		this.hidden=hidden;
	}
	public IdAttribute getIdAttribute() {
		return this.id;
	}
	public void setIdAttribute(IdAttribute id) {
		this.id=id;
	}
	public LangAttribute getLangAttribute() {
		return this.lang;
	}
	public void setLangAttribute(LangAttribute lang) {
		this.lang=lang;
	}
	public SpellcheckAttribute getSpellcheckAttribute() {
		return this.spellcheck;
	}
	public void setSpellcheckAttribute(SpellcheckAttribute spellcheck) {
		this.spellcheck=spellcheck;
	}
	public StyleAttribute getStyleAttribute() {
		return this.style;
	}
	public void setStyleAttribute(StyleAttribute style) {
		this.style=style;
	}
	public TabindexAttribute getTabindexAttribute() {
		return this.tabindex;
	}
	public void setTabindexAttribute(TabindexAttribute tabindex) {
		this.tabindex=tabindex;
	}
	public TitleAttribute getTitleAttribute() {
		return this.title;
	}
	public void setTitleAttribute(TitleAttribute title) {
		this.title=title;
	}
	public TranslateAttribute getTranslateAttribute() {
		return this.translate;
	}
	public void setTranslateAttribute(TranslateAttribute translate) {
		this.translate=translate;
	}
}
