package fr.orantoine.fortnitegenerationv2.repository;

import fr.orantoine.fortnitegenerationv2.models.Joueur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JoueurRepository extends MongoRepository<Joueur,String> {
    Joueur findByPseudo(String pseudo);
}
