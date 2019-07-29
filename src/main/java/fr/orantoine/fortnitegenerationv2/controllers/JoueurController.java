package fr.orantoine.fortnitegenerationv2.controllers;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import fr.orantoine.fortnitegenerationv2.models.Joueur;
import fr.orantoine.fortnitegenerationv2.repository.JoueurRepository;
import fr.orantoine.fortnitegenerationv2.services.JoueurService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/joueur")
public class JoueurController {

    @Autowired
    private JoueurRepository joueurRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<Joueur>> findAll(){
        List<Joueur> joueurs = joueurRepository.findAll();
        return ResponseEntity.status(200).body(joueurs);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Joueur> findOne(@PathVariable String id){
        Optional<Joueur> joueurOpt = joueurRepository.findById(id);
        if (joueurOpt.isPresent()) {
            Joueur joueur = joueurOpt.get();
            return ResponseEntity.status(200).body(joueur);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "")
    public ResponseEntity<Void> addJoueur(@RequestBody Joueur joueur){
        if (joueur.getAccountid() == null && joueur.getPseudo() == null) {
            return ResponseEntity.badRequest().build();
        }
        Joueur joueurAddded = joueurRepository.save(joueur);
        if(joueurAddded == null){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(joueurAddded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteJoueur(@PathVariable String id){
        joueurRepository.deleteById(id);
        return ResponseEntity.accepted().build();

    }


    @GetMapping(value = "/search/{id}")
    public ResponseEntity<Joueur> searchJoueur(@PathVariable String id){
        try {
            HttpResponse<String> jsonResponse = Unirest.get("https://api.fortnitetracker.com/v1/profile/ps4/" + id)
                    .header("accept", "application/json")
                    .header("TRN-Api-Key", "2dda56fe-8332-49f0-a4b5-7266757efdf4")
                    .header("cache-control", "no-cache").asString();
            JSONObject jsonObject = new JSONObject(jsonResponse.getBody());
            if(jsonObject.has("error")) {
                return ResponseEntity.notFound().build();
            }
            else{
                JoueurService joueurService = new JoueurService();
                Joueur joueur = joueurService.createJoueur(jsonObject);
                Joueur joueurAdded = joueurRepository.save(joueur);
                if (joueurAdded != null) {
                    URI location = ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/joueur/{id}")
                            .buildAndExpand(joueurAdded.getId())
                            .toUri();
                    return ResponseEntity.status(200).location(location).body(joueurAdded);
                }
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(500).build();
    }
}
