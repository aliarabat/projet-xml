package com.documents.service;

import com.documents.models.DocumentModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
public class DocumentService {

    private List<DocumentModel> docs = new ArrayList<>();

    public DocumentService() {
    }

    public int search(String propreitere, String source) {

        File inputFile = new File("C:\\Users\\hp\\Desktop\\MS-ISI-S1\\AnaDocElec\\projet\\documents.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        NodeList list;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            if (!propreitere.equals("") && !source.equals("")) {

                source = source.substring(0, source.length() - 1);
                String exp = "//" + source.toLowerCase() + "[contains(//proprietere[contains('" + propreitere + "',nom) or contains('" + propreitere + "', prenom)]/@" + source.toLowerCase() + ", @id)]";
                System.out.println(exp);
                NodeList nodeList = (NodeList) xPath.compile(exp).evaluate(
                        doc, XPathConstants.NODESET);
                addList(nodeList, propreitere, source);
                return 1;
            } else {
                source = source.substring(0, source.length() - 1);
                String exp = "//" + source.toLowerCase();
                NodeList nodeList = (NodeList) xPath.compile(exp).evaluate(
                        doc, XPathConstants.NODESET);
                addList(nodeList, propreitere, source);
                return 1;
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
        } catch (XPathExpressionException ex) {
            Logger.getLogger(DocumentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -2;
    }

    public void addList(NodeList list, String proprietere, String source) {
        docs.clear();
        if (list.getLength() >= 1) {
            for (int i = 0; i < list.getLength(); i++) {
                Node these = list.item(i);
                if (these.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) these;
                    DocumentModel documentModel = new DocumentModel();
                    documentModel.setAnneeScolaire(el.getAttribute("anneeScolaire"));
                    documentModel.setProprietere(proprietere);
                    documentModel.setSource(el.getNodeName());
                    documentModel.setTheme(el.getElementsByTagName("theme" + source).item(0).getTextContent());
                    docs.add(documentModel);
                }
            }
        }
    }

    public List<DocumentModel> getDocs() {
        return docs;
    }

    public void setDocs(List<DocumentModel> docs) {
        this.docs = docs;
    }

}
