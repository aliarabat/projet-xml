/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documents.models;

import java.util.Objects;

/**
 *
 * @author hp
 */
public class DocumentModel {

    private String proprietere;
    private String source;
    private String theme;
    private String anneeScolaire;

    public DocumentModel() {
    }

    public DocumentModel(String proprietere, String source, String theme, String anneeScolaire) {
        this.proprietere = proprietere;
        this.source = source;
        this.theme = theme;
        this.anneeScolaire = anneeScolaire;
    }

    public String getProprietere() {
        return proprietere;
    }

    public void setProprietere(String proprietere) {
        this.proprietere = proprietere;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.proprietere);
        hash = 79 * hash + Objects.hashCode(this.source);
        hash = 79 * hash + Objects.hashCode(this.theme);
        hash = 79 * hash + Objects.hashCode(this.anneeScolaire);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DocumentModel other = (DocumentModel) obj;
        if (!Objects.equals(this.proprietere, other.proprietere)) {
            return false;
        }
        if (!Objects.equals(this.source, other.source)) {
            return false;
        }
        if (!Objects.equals(this.theme, other.theme)) {
            return false;
        }
        if (!Objects.equals(this.anneeScolaire, other.anneeScolaire)) {
            return false;
        }
        return true;
    }

}
