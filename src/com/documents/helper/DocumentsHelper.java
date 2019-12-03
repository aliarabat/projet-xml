/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documents.helper;

import com.documents.models.DocumentModel;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Chaimaa-abd
 */
public class DocumentsHelper extends AbstractHelper<DocumentModel> {

    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("Proprietere", "proprietere"),
            new AbstractHelperItem("Source", "source"),
            new AbstractHelperItem("Theme", "theme"),
            new AbstractHelperItem("Annee", "anneeScolaire"),};
    }

    public DocumentsHelper(JTable jTable, List<DocumentModel> list) {
        super(titres, jTable, list);
    }

    public DocumentsHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public DocumentsHelper(JTable jTable) {
        super(titres, jTable);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (list != null && rowIndex < list.size()) {
            for (int i = 0; i < abstractHelperItem.length; i++) {
                switch (columnIndex) {
                    default:
                        return super.getValueAt(rowIndex, columnIndex);
                }
            }
        }
        return null;
    }
}
