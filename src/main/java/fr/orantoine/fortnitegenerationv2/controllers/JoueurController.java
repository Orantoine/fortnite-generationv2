package fr.orantoine.fortnitegenerationv2.controllers;


import fr.orantoine.fortnitegenerationv2.models.Joueur;
import fr.orantoine.fortnitegenerationv2.repository.JoueurRepository;
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
}
