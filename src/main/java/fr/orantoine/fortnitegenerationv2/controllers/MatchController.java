package fr.orantoine.fortnitegenerationv2.controllers;


import fr.orantoine.fortnitegenerationv2.models.Day;
import fr.orantoine.fortnitegenerationv2.models.Joueur;
import fr.orantoine.fortnitegenerationv2.models.Match;
import fr.orantoine.fortnitegenerationv2.repository.JoueurRepository;
import fr.orantoine.fortnitegenerationv2.repository.MatchRepository;
import fr.orantoine.fortnitegenerationv2.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/match")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private JoueurRepository joueurRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<Match>> findAll(){
        List<Match> matches = matchRepository.findAll();
        if(matches.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(200).body(matches);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Match> findOne(@PathVariable int id){
        Optional<Match> matchOpt = matchRepository.findById(id);
        if (matchOpt.isPresent())
            return ResponseEntity.status(200).body(matchOpt.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/joueur/{pseudo}")
    public ResponseEntity<List<Match>> findByPseudo(@PathVariable String pseudo){
        Joueur joueur = joueurRepository.findByPseudo(pseudo);
        if (joueur == null){
            return ResponseEntity.notFound().build();
        }
        else{
            List<Match> matchs = matchRepository.findByAccountId(joueur.getAccountid());
            if(matchs.isEmpty())
                return ResponseEntity.noContent().build();
            return ResponseEntity.status(200).body(matchs);
        }
    }

    @GetMapping(value ="/day/{pseudo}")
    public ResponseEntity<List<Day>> findOrderByDay(@PathVariable String pseudo){
        Joueur joueur = joueurRepository.findByPseudo(pseudo);
        if (joueur == null){
            return ResponseEntity.notFound().build();
        }
        else {
            List<Match> matchs = matchRepository.findByAccountIdOrderByDateCollected(joueur.getAccountid());
            if(matchs.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            else {
                DayService dayService = new DayService();
                List<Day> days = dayService.getDays(matchs);
                for (Day day: days){
                    day.setJoueur(joueur);
                }
                return ResponseEntity.status(200).body(days);
            }

        }
    }




}
