package fr.covea.hackdds.domain;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;

/**
 * @author laurent
 */
public class Prestation {

   @Id
   private BigInteger id;
   private String annee;
   private String mois;
   private String naturePrestation;
   private String natureAssurance;
   private String modulationTicket;
   private String exonerationTicket;
   private String sexeBeneficiaire;
   private int ageBeneficiaire;
   private String zoneBeneficiaire;
   private int tauxRemboursement;
   private String typeRemboursement;
   private String specialiteExecutant;
   private String activiteExecutant;
   private String zoneExecutant;
   private String disciplineExecutant;
   private double montantDepassement;
   private double montantPaiement;
   private double montantRemboursement;
   private double baseRemboursement;
   private double coefficientGlobal;
   private double nombreActes;
   private double quantiteActes;

   public BigInteger getId() {
      return id;
   }

   public String getAnnee() {
      return annee;
   }

   public void setAnnee(String annee) {
      this.annee = annee;
   }

   public String getMois() {
      return mois;
   }

   public void setMois(String mois) {
      this.mois = mois;
   }

   public String getNaturePrestation() {
      return naturePrestation;
   }

   public void setNaturePrestation(String naturePrestation) {
      this.naturePrestation = naturePrestation;
   }

   public String getNatureAssurance() {
      return natureAssurance;
   }

   public void setNatureAssurance(String natureAssurance) {
      this.natureAssurance = natureAssurance;
   }

   public String getModulationTicket() {
      return modulationTicket;
   }

   public void setModulationTicket(String modulationTicket) {
      this.modulationTicket = modulationTicket;
   }

   public String getExonerationTicket() {
      return exonerationTicket;
   }

   public void setExonerationTicket(String exonerationTicket) {
      this.exonerationTicket = exonerationTicket;
   }

   public String getSexeBeneficiaire() {
      return sexeBeneficiaire;
   }

   public void setSexeBeneficiaire(String sexeBeneficiaire) {
      this.sexeBeneficiaire = sexeBeneficiaire;
   }

   public int getAgeBeneficiaire() {
      return ageBeneficiaire;
   }

   public void setAgeBeneficiaire(int ageBeneficiaire) {
      this.ageBeneficiaire = ageBeneficiaire;
   }

   public String getZoneBeneficiaire() {
      return zoneBeneficiaire;
   }

   public void setZoneBeneficiaire(String zoneBeneficiaire) {
      this.zoneBeneficiaire = zoneBeneficiaire;
   }

   public int getTauxRemboursement() {
      return tauxRemboursement;
   }

   public void setTauxRemboursement(int tauxRemboursement) {
      this.tauxRemboursement = tauxRemboursement;
   }

   public String getTypeRemboursement() {
      return typeRemboursement;
   }

   public void setTypeRemboursement(String typeRemboursement) {
      this.typeRemboursement = typeRemboursement;
   }

   public String getSpecialiteExecutant() {
      return specialiteExecutant;
   }

   public void setSpecialiteExecutant(String specialiteExecutant) {
      this.specialiteExecutant = specialiteExecutant;
   }

   public String getActiviteExecutant() {
      return activiteExecutant;
   }

   public void setActiviteExecutant(String activiteExecutant) {
      this.activiteExecutant = activiteExecutant;
   }

   public String getZoneExecutant() {
      return zoneExecutant;
   }

   public void setZoneExecutant(String zoneExecutant) {
      this.zoneExecutant = zoneExecutant;
   }

   public String getDisciplineExecutant() {
      return disciplineExecutant;
   }

   public void setDisciplineExecutant(String disciplineExecutant) {
      this.disciplineExecutant = disciplineExecutant;
   }

   public double getMontantDepassement() {
      return montantDepassement;
   }

   public void setMontantDepassement(double montantDepassement) {
      this.montantDepassement = montantDepassement;
   }

   public double getMontantPaiement() {
      return montantPaiement;
   }

   public void setMontantPaiement(double montantPaiement) {
      this.montantPaiement = montantPaiement;
   }

   public double getMontantRemboursement() {
      return montantRemboursement;
   }

   public void setMontantRemboursement(double montantRemboursement) {
      this.montantRemboursement = montantRemboursement;
   }

   public double getBaseRemboursement() {
      return baseRemboursement;
   }

   public void setBaseRemboursement(double baseRemboursement) {
      this.baseRemboursement = baseRemboursement;
   }

   public double getCoefficientGlobal() {
      return coefficientGlobal;
   }

   public void setCoefficientGlobal(double coefficientGlobal) {
      this.coefficientGlobal = coefficientGlobal;
   }

   public double getNombreActes() {
      return nombreActes;
   }

   public void setNombreActes(double nombreActes) {
      this.nombreActes = nombreActes;
   }

   public double getQuantiteActes() {
      return quantiteActes;
   }

   public void setQuantiteActes(double quantiteActes) {
      this.quantiteActes = quantiteActes;
   }
}
