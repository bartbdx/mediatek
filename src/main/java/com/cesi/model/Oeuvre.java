package com.cesi.model;

/**
 * Created by Philippe on 03/06/2017.
 */
public abstract class Oeuvre {
    protected String titre;
    protected String auteur;
    protected String origine;
    protected int note;
    protected String commentaire;

    public Oeuvre(String titre, String auteur, String origine, int note, String commentaire) {
        this.titre = titre;
        this.auteur = auteur;
        this.origine = origine;
        this.note = note;
        this.commentaire = commentaire;
    }

    public Oeuvre() {

    }

    public String getTitre() {
        return titre;
    }

    public Oeuvre setTitre(String titre) {
        this.titre = titre;
        return this;
    }

    public String getAuteur() {
        return auteur;
    }

    public Oeuvre setAuteur(String auteur) {
        this.auteur = auteur;
        return this;
    }

    public String getOrigine() {
        return origine;
    }

    public Oeuvre setOrigine(String origine) {
        this.origine = origine;
        return this;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
