package fr.covea.hackdds;

import fr.covea.hackdds.domain.Prestation;
import fr.covea.hackdds.repository.PrestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * @author laurent
 */
@ComponentScan
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

   @Autowired
   private PrestationRepository repository;


   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

   @Override
   public void run(String... args) throws Exception {
      //repository.deleteAll();

      Prestation prestation = new Prestation();
      prestation.setAnnee("2010");
      prestation.setMois("1");
      prestation.setAgeBeneficiaire(36);
      prestation.setSexeBeneficiaire("H");
      prestation.setZoneBeneficiaire("1");
      prestation.setMontantRemboursement(23.5);
      prestation.setMontantPaiement(26);
      prestation.setNaturePrestation("1901");
      repository.save(prestation);

      prestation = new Prestation();
      prestation.setAnnee("2010");
      prestation.setMois("2");
      prestation.setAgeBeneficiaire(36);
      prestation.setSexeBeneficiaire("F");
      prestation.setZoneBeneficiaire("1");
      prestation.setMontantRemboursement(16.5);
      prestation.setMontantPaiement(24);
      prestation.setNaturePrestation("0119");
      repository.save(prestation);
   }
}
