package fr.covea.hackdds.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.covea.hackdds.domain.Prestation;
/**
 * @author  laurent
 */
public interface PrestationRepository extends MongoRepository<Prestation, String> {

}
