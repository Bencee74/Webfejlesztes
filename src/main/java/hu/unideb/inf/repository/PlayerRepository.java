package hu.unideb.inf.repository;

import hu.unideb.inf.model.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Repository
public interface PlayerRepository extends ReactiveMongoRepository<Player, Long> {
}