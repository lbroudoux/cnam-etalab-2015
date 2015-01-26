package fr.covea.hackdds.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.covea.hackdds.domain.Prestation;
/**
 * @author  laurent
 */
public interface PrestationRepository extends MongoRepository<Prestation, String> {

   // Montant de la dépense répartit selon taux de remboursement (histo empilé)
   // Groupement par année et ou par mois.


}
