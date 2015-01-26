package fr.covea.hackdds.web;

import fr.covea.hackdds.domain.Prestation;
import fr.covea.hackdds.repository.PrestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
/**
 * @author laurent
 */
@RestController
public class PrestationController {

   @Autowired
   private PrestationRepository repository;

   @Autowired
   private MongoTemplate mongoTemplate;

   @RequestMapping("/prestation/{annee}/{mois}")
   public List<Prestation> byMonth(
         @PathVariable("annee") String annee,
         @PathVariable("mois") String mois) {

      return repository.findAll();
   }

   @RequestMapping("/remboursement/montantParAnnee")
   public List<Remboursement> montantDepense(){

      Aggregation agg = newAggregation(
         group("annee").sum("montantRemboursement").as("montant"),
         project("montant").and("annee").previousOperation()
      );
      AggregationResults<Remboursement> results = mongoTemplate.aggregate(agg,
            "prestation", Remboursement.class);

      return results.getMappedResults();
   }

   // Inner beans
   class Remboursement {
      Double montant;
      String annee;

      public Double getMontant() {
         return montant;
      }
      public void setMontant(Double montant) {
         this.montant = montant;
      }
      public String getAnnee() {
         return annee;
      }
      public void setAnnee(String annee) {
         this.annee = annee;
      }
   }
}
