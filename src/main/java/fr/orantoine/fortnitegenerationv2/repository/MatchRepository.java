package fr.orantoine.fortnitegenerationv2.repository;

import fr.orantoine.fortnitegenerationv2.models.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MatchRepository extends MongoRepository<Match,Integer> {
    List<Match> findByAccountId(String accountId);
    List<Match> findByAccountIdOrderByDateCollected(String accountId);
}
