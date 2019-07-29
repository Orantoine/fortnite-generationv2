package fr.orantoine.fortnitegenerationv2.services;

import fr.orantoine.fortnitegenerationv2.models.Joueur;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JoueurService {

    public JoueurService() {

    }

    public Joueur createJoueur(JSONObject jsonObject){
        Joueur joueur = new Joueur();
        joueur.setAccountid(jsonObject.getString("accountId"));
        joueur.setPseudo(jsonObject.getString("epicUserHandle"));
        String[] plateforme = new String[]{jsonObject.getString("platformName")};
        joueur.setPlateforme(plateforme);
        return joueur;
    }
}
