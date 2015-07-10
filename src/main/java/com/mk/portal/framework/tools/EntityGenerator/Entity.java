package com.mk.portal.framework.tools.EntityGenerator;

import java.util.HashMap;
import java.util.Map;

public class Entity {
	private String packageName;
	private String className;
	private Map<String, String> fields;

	public String getPackageName() {
		return packageName;
	}

	public Entity(String packageName, String className,
			Map<String, String> fields) {
		super();
		this.packageName = packageName;
		this.className = className;
		this.fields = fields;
	}

	public Entity() {
		super();
		this.fields = new HashMap<String, String>();
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void addField(String fieldType, String fieldName) {
		fields.put(fieldName, fieldType);
	}

	public String toString() {
		StringBuffer cb = new StringBuffer("");
		cb.append("package " + packageName + ";");
		cb.append("\n");
		cb.append("public class " + className + " {");
		cb.append("\n");

		for (String field : fields.keySet()) {
			cb.append("\tprivate " + getFieldType(field) + " " + field + ";");
			cb.append("\n");
		}
		for (String field : fields.keySet()) {
			String method = getFieldType(field).equals("boolean") ? "is"
					: "get";
			cb.append("\tpublic " + getFieldType(field) + " "
					+ getMethodName(method, field) + "(){\n");
			cb.append("\t\t return " + field + ";\n");
			cb.append("\t}\n");
		}
		for (String field : fields.keySet()) {
			cb.append("\tpublic void " + getMethodName("set", field) + "("
					+ getFieldType(field) + " param)" + "{\n");
			cb.append("\t\t this." + field + " = param;\n");
			cb.append("\t}\n");
		}
		cb.append("}");
		return cb.toString();

	}

	private String getFieldType(String field) {
		String val = fields.get(field);
		if (val.equals("string")) {
			return "String";
		} else {
			return fields.get(field);
		}

	}

	private String getMethodName(String method, String field) {
		return method + String.valueOf(field.charAt(0)).toUpperCase()
				+ field.substring(1);
	}

}
