package com.source.module.parse;

import java.io.FileReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Main1217 {
	
	public static void main1(String[] args) throws Exception {
		long f=System.currentTimeMillis();
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(false);
		documentBuilderFactory.setNamespaceAware(false);
		documentBuilderFactory.setIgnoringComments(true);
		DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
		Document document=documentBuilder.parse("src/mybatis-config.xml");
		XPath xPath=XPathFactory.newInstance().newXPath();
		XPathExpression expression=xPath.compile("configuration/mappers/mapper");
		NodeList nodeList=(NodeList) expression.evaluate(document, XPathConstants.NODESET);
		for(int i=0;i<nodeList.getLength();i++){
			System.out.println(nodeList.item(i).getNodeName()+"-"+nodeList.item(i).getNodeType()
					+"-"+nodeList.item(i).getAttributes().getNamedItem("resource"));
		}
		System.err.println("花费时间(ms):"+(System.currentTimeMillis()-f));
	}
	
	public static void main(String[] args) throws Exception {
		XPathParser parser=new XPathParser(new FileReader("src/mybatis-config.xml"), true, null, new XMLMapperEntityResolver());
		XNode node=parser.evalNode("configuration/mappers");
		System.err.println(node.toString());
		List<XNode> nodes=parser.evalNodes("configuration/mappers/mapper");
		for(XNode xNode:nodes){
			System.out.println(xNode.getStringAttribute("resource"));
		}
	}
}