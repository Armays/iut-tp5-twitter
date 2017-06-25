package edu.lyon1.twitter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "utilisateurs")
public class Utilisateur implements Serializable {
    @Id
    private String handle;
    private Timestamp inscription;
    private String prenom;
    private String nom;

    public Utilisateur(String handle, Timestamp inscription, String prenom, String nom) {
        this.handle = handle;
        this.inscription = inscription;
        this.prenom = prenom;
        this.nom = nom;
    }

    public Utilisateur() {
    }

    public String getHandle() {
        return handle;
    }

    public Timestamp getInscription() {
        return inscription;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public void setInscription(Timestamp inscription) {
        this.inscription = inscription;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.prenom + ' ' + this.nom + ' ' + this.inscription + ' ' + this.handle;
    }
}
