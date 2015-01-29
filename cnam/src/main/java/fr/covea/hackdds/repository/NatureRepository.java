package fr.covea.hackdds.repository;

import fr.covea.hackdds.domain.Nature;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author laurent
 */
public interface NatureRepository extends MongoRepository<Nature, String> {

}
