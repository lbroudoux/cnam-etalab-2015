package fr.covea.hackdds.domain;

import org.springframework.data.annotation.Id;

/**
 * @author laurent
 */
public class Nature {

   @Id
   private long id;

   private int acteMarqueur;
}
