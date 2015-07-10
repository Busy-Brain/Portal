package com.mk.portal.framework.tools.EntityGenerator;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EntityGenerator {
	public static void main(String[] args) {
		File parentFolder = new File(getBaseFolderPath());
		if (parentFolder.isDirectory()) {
			File[] hbmFiles = parentFolder.listFiles();
			for (File hbmFile : hbmFiles) {
				readFile(hbmFile);
			}
		}
	}

	private static void readFile(File hbmFile) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			System.out.println("reading file:-"+hbmFile.getName());
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(hbmFile);
			Entity entity= new Entity();
			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			Element rootElement = doc.getDocumentElement();
			System.out.println("Root element :"
					+ rootElement.getNodeName());
			NodeList childElements=rootElement.getChildNodes();

			System.out.println("----------------------------");

			for (int temp = 0; temp < childElements.getLength(); temp++) {

				Node nNode = childElements.item(temp);
				if(nNode.getNodeName().equals("class")){
					NamedNodeMap attributeMap=nNode.getAttributes();
					String nameVal = attributeMap.getNamedItem("name").getNodeValue();
					int lastDotPosition=nameVal.lastIndexOf(".");
					System.out.println(nameVal);
					System.out.println(lastDotPosition);
					entity.setClassName(nameVal.substring(lastDotPosition+1));
					entity.setPackageName(nameVal.substring(0,lastDotPosition));
					NodeList nl=nNode.getChildNodes();
					for(int a=0;a<nl.getLength();a++){
						Node cNode=nl.item(a);
						if(cNode.getNodeName().equals("id")||cNode.getNodeName().equals("property")){
							NamedNodeMap aMap=cNode.getAttributes();
							entity.addField(aMap.getNamedItem("type").getNodeValue(), aMap.getNamedItem("name").getNodeValue());
						}
					}
				}
				if((entity!=null)&&(entity.getPackageName()!=null)){
					String a=entity.getPackageName().replace("\\.", "/");
					System.out.println(a);
					System.out.println(entity);
				}
				

				/*
				 * if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				 * 
				 * Element eElement = (Element) nNode;
				 * 
				 * System.out.println("Staff id : " +
				 * eElement.getAttribute("id"));
				 * System.out.println("First Name : " +
				 * eElement.getElementsByTagName
				 * ("firstname").item(0).getNodeValue());
				 * System.out.println("Last Name : " +
				 * eElement.getElementsByTagName
				 * ("lastname").item(0).getNodeValue());
				 * System.out.println("Nick Name : " +
				 * eElement.getElementsByTagName
				 * ("nickname").item(0).getNodeValue());
				 * System.out.println("Salary : " +
				 * eElement.getElementsByTagName
				 * ("salary").item(0).getNodeValue());
				 * 
				 * }
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getBaseFolderPath() {
		return "/home/mohit/personal/github/Portal/src/main/resources/orm";
	}
}
