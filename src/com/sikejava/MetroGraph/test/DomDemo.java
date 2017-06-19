package com.sikejava.MetroGraph.test;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/********************************************************************************
 * MetroGraph -- 解析xml文档 Dom版本
 * @version 2017/06/14 11:24
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/
public class DomDemo implements XmlDocument {

    private Document mDocument;

    @Override
    public void parseXml(String fileName) {

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            mDocument = db.parse(fileName);
            NodeList users = mDocument.getChildNodes();

            for (int i = 0; i < users.getLength(); i++) {
                Node user = users.item(i);
                NodeList userInfo = user.getChildNodes();

                for (int j = 0; j < userInfo.getLength(); j++) {
                    Node node = userInfo.item(j);
                    NodeList userMeta = node.getChildNodes();
                    if (node.getNodeName() == "user") {
                        NamedNodeMap namedNodeMap = node.getAttributes();
                        String s = namedNodeMap.getNamedItem("id").getTextContent();
                        System.out.println("id : " + s);
                    }

                    for (int k = 0; k < userMeta.getLength(); k++) {
                        if (userMeta.item(k).getNodeName() != "#text") {
                            System.out.println(userMeta.item(k).getNodeName() + ":" + userMeta.item(k).getTextContent());
                        }

                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
