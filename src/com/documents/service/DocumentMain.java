/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documents.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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

/**
 *
 * @author hp
 */
public class DocumentMain extends JFrame implements ActionListener {

    Vector data = new Vector();
    Vector columns = new Vector();
    JTable table = new JTable();

    public DocumentMain() {
        super();

//        GridLayout glMain=new GridLayout(2, 1);
//        GridLayout formGrid=new GridLayout(1, 2);
//        GridLayout gl1=new GridLayout(2, 2);
//        GridLayout gl2=new GridLayout(2, 2);
        //Labels
        JLabel propLabel = new JLabel("Proprietere");
        JLabel themeLabel = new JLabel("Theme");
        JLabel sourceLabel = new JLabel("Source");

        //TextFields
        JTextField propTextField = new JTextField();
        JTextField themeTextField = new JTextField();
        JComboBox sourceComboBox = new JComboBox();

        //Buttons
        JButton searchButton = new JButton("Rechercher");
        searchButton.addActionListener(this);

        //Panel
        JPanel panel = new JPanel(new GridLayout(2, 4));
        //L'ajout des elements
//        Container c1=new Container();
        panel.add(propLabel);
        panel.add(propTextField);
        panel.add(sourceLabel);
        panel.add(sourceComboBox);

//        Container c2=new Container();
        panel.add(themeLabel);
        panel.add(themeTextField);
        panel.add(searchButton);

        add(panel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        setTitle("Systeme de documents éléctroniques");
        setSize(400, 100);

    }

    public static void main(String[] args) {
        DocumentMain dm = new DocumentMain();
        dm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Rechercher")) {
            try {
                File inputFile = new File("C:\\Users\\hp\\Desktop\\MS-ISI-S1\\AnaDocElec\\projet\\documents.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder;

                dBuilder = dbFactory.newDocumentBuilder();

                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();

                XPath xPath = XPathFactory.newInstance().newXPath();

                String expression = "/document/theses/*";
                NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
                        doc, XPathConstants.NODESET);

//            String proprietere = propTextField.getText();
//            String theme = themeTextField.getText();
//            String source = sourceComboBox.getSelectedItem().toString();
                if (true) {
                    columns.addElement("Proprietere");
                    columns.addElement("Source");
                    columns.addElement("Theme");
                    columns.addElement("Annee");
                    System.out.println("Lenght est " + nodeList.getLength());
//                JOptionPane.showMessageDialog(null, "Info Msg", "Recherche par propritere", JOptionPane.INFORMATION_MESSAGE);
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        Node these = nodeList.item(i);
                        if (these.getNodeType() == Node.ELEMENT_NODE) {
                            Element el = (Element) these;
                            Vector row = new Vector(4);
                            row.addElement("prop1");
                            row.addElement(el.getNodeName());
                            System.out.println(el.getElementsByTagName("themeThese").item(0).getTextContent());
                            row.addElement(el.getElementsByTagName("themeThese").item(0).getTextContent());
                            row.addElement(el.getAttribute("anneeScolaire"));
                            data.addElement(row);
                        }
                    }
                    table = new JTable(data, columns);
                }

            } catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException ex) {
            }
        }
    }
}
