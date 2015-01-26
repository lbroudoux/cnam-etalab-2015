package fr.covea.hackdds.web;

import fr.covea.hackdds.domain.Prestation;
import fr.covea.hackdds.repository.PrestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

   @RequestMapping("/depense/montantParAnnee")
   public List<SommeAnnuel> montantDepense(){

      Aggregation agg = newAggregation(
         match(Criteria.where("naturePrestation").not().regex("^19", "i")),
         group("annee").sum("montantPaiement").as("montant"),
         project("montant").and("annee").previousOperation()
      );
      AggregationResults<SommeAnnuel> results = mongoTemplate.aggregate(agg,
            "prestation", SommeAnnuel.class);

      return results.getMappedResults();
   }

   @RequestMapping("/remboursement/montantParAnnee")
   public List<SommeAnnuel> montantRemboursement(){

      Aggregation agg = newAggregation(
         match(Criteria.where("naturePrestation").not().regex("^19", "i")),
         group("annee").sum("montantRemboursement").as("montant"),
         project("montant").and("annee").previousOperation()
      );
      AggregationResults<SommeAnnuel> results = mongoTemplate.aggregate(agg,
            "prestation", SommeAnnuel.class);

      return results.getMappedResults();
   }

   @RequestMapping("/ratio/remboursementPaiementParAnnee")
   public List<RatioAnnuel> ratioRemboursementPaiement() {

      Aggregation agg = newAggregation(
            match(Criteria.where("naturePrestation").not().regex("^19", "i")),
            group("annee")
                  .sum("montantRemboursement").as("remboursement")
                  .sum("montantPaiement").as("paiement"),
            project("annee")
                  .and("remboursement").divide("paiement").as("ratio").and("annee").previousOperation()
      );
      AggregationResults<RatioAnnuel> results = mongoTemplate.aggregate(agg,
            "prestation", RatioAnnuel.class);

      return results.getMappedResults();
   }

   @RequestMapping("/nonRemboursement/montantParAnnee")
   public List<SommeAnnuel> montantNonRemboursement() {

      Aggregation agg = newAggregation(
            match(Criteria.where("naturePrestation").not().regex("^19", "i")),
            group("annee")
                  .sum("montantRemboursement").as("remboursement")
                  .sum("montantPaiement").as("paiement"),
            project("annee")
                  .and("paiement").minus("remboursement").as("montant").and("annee").previousOperation()
      );
      AggregationResults<SommeAnnuel> results = mongoTemplate.aggregate(agg,
            "prestation", SommeAnnuel.class);

      return results.getMappedResults();
   }

   @RequestMapping("/nonRemboursement/montantParAnneePourPrestations")
   public List<SommeAnnuel> montantNonRemboursementPourPrestations(
         @RequestParam(value="natures", required=true) List<String> natures) {

      Criteria c = Criteria.where("naturePrestation");
      for (int i=0; i<natures.size(); i++){
         String nature = natures.get(i);
         if (i == 0) {
            c.regex("^" + nature, "i");
         } else {
            c.orOperator(c.regex("^" + nature, "i"));
         }
      }
      Aggregation agg = newAggregation(
            match(c.andOperator(Criteria.where("naturePrestation").not().regex("^19", "i"))),
            group("annee")
                  .sum("montantRemboursement").as("remboursement")
                  .sum("montantPaiement").as("paiement"),
            project("annee")
                  .and("paiement").minus("remboursement").as("montant").and("annee").previousOperation()
      );
      AggregationResults<SommeAnnuel> results = mongoTemplate.aggregate(agg,
            "prestation", SommeAnnuel.class);

      return results.getMappedResults();
   }

   // Inner beans
   class RatioAnnuel {
      Double ratio;
      String annee;

      public Double getRatio() {
         return ratio;
      }
      public void setRatio(Double ratio) {
         this.ratio = ratio;
      }

      public String getAnnee() {
         return annee;
      }
      public void setAnnee(String annee) {
         this.annee = annee;
      }
   }

   class SommeAnnuel {
      Double montant;
      Double montantTaux100;
      Double montantTauxAutres;
      String annee;

      public Double getMontant() {
         return montant;
      }
      public void setMontant(Double montant) {
         this.montant = montant;
      }

      public Double getMontantTaux100() {
         return montantTaux100;
      }
      public void setMontantTaux100(Double montantTaux100) {
         this.montantTaux100 = montantTaux100;
      }

      public Double getMontantTauxAutres() {
         return montantTauxAutres;
      }
      public void setMontantTauxAutres(Double montantTauxAutres) {
         this.montantTauxAutres = montantTauxAutres;
      }

      public String getAnnee() {
         return annee;
      }
      public void setAnnee(String annee) {
         this.annee = annee;
      }
   }
}
