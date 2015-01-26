package fr.covea.hackdds;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * @author laurent
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {

   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }
}
