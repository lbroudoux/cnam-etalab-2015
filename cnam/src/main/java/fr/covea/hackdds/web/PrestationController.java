package fr.covea.hackdds.web;

import fr.covea.hackdds.domain.Prestation;
import fr.covea.hackdds.repository.PrestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author laurent
 */
@RestController
public class PrestationController {

   @Autowired
   private PrestationRepository repository;

   @RequestMapping("/prestation/{annee}/{mois}")
   public List<Prestation> byMonth(
         @PathVariable("annee") String annee,
         @PathVariable("mois") String mois) {

      return repository.findAll();
   }
}
