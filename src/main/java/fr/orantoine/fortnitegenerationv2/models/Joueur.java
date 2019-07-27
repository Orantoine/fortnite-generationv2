package fr.orantoine.fortnitegenerationv2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;


@Document(value = "Joueur")
public class Joueur {

    @Id
    private String id;

    private String accountid;

    private String pseudo;

    private String adresse;

    private String[] plateforme;

    public Joueur(String id, String accountid, String pseudo, String adresse, String[] plateforme) {
        this.id = id;
        this.accountid = accountid;
        this.pseudo = pseudo;
        this.adresse = adresse;
    }

    public Joueur() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String[] getPlateforme() {
        return plateforme;
    }

    public void setPlateforme(String[] plateforme) {
        this.plateforme = plateforme;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "id='" + id + '\'' +
                ", accountid='" + accountid + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", adresse='" + adresse + '\'' +
                ", plateforme=" + Arrays.toString(plateforme) +
                '}';
    }
}
