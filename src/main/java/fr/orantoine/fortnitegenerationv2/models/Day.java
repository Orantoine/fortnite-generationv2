package fr.orantoine.fortnitegenerationv2.models;

import java.util.Date;
import java.util.List;

public class Day {

    private Joueur joueur;
    private List<Match> matches;
    private Date day;

    public Day(Joueur joueur, List<Match> matches, Date day) {
        this.joueur = joueur;
        this.matches = matches;
        this.day = day;
    }

    public Day() {
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Day{" +
                "joueur=" + joueur +
                ", matches=" + matches +
                ", day=" + day +
                '}';
    }
}
