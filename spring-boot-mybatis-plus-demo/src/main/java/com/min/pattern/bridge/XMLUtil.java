package com.min.pattern.bridge;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil {

	// 该方法用于从xml配置文件中提取具体的类名，并返回一个实例对象
	public static Object getBean(String args) {
		// 创建文档对象
		try {
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc = builder.parse(new File("src/main/resources/conf/config.xml"));
			NodeList nodeList = doc.getElementsByTagName("className");
			Node node = null;
			String className = null;

			if (args.equals("images")) {
				// 获取第一个包含类名的节点，即扩充抽象类
				node = nodeList.item(0).getFirstChild();
			}

			if (args.equals("os")) {
				// 获取第二个包含类名的节点，即具体实现类
				node = nodeList.item(1).getFirstChild();
			}

			className = node.getNodeValue();
			Class<?> clazz = Class.forName(className);
			return clazz.newInstance();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
