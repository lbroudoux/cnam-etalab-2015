package fr.covea.hackdds.web;

import fr.covea.hackdds.domain.Nature;
import fr.covea.hackdds.domain.Prestation;
import fr.covea.hackdds.repository.NatureRepository;
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
public class NatureController {

   @Autowired
   private NatureRepository repository;

   @RequestMapping("/nature/{groupePrestation}")
   public List<Nature> byGroupePrestation(
         @PathVariable("groupePrestation") String groupePrestation) {

      return repository.findByGroupePrestation(groupePrestation);
   }
}
