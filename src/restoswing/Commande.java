    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restoswing;

import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class Commande {
    
    private Integer idCommande;
    private Integer etatCommande;
    private Float totalCommandeTTC;
    private String typeCommande;
    private String dateCommande;
    private String heureCommande;
    private Integer idUtilisateur;
    private ArrayList<LigneCommande> lignesCommande;

    public Commande(Integer idCommande , Integer etatCommande, Float totalCommandeTTC, String typeCommande, String dateCommande, String heureCommande, Integer idUtilisateur, ArrayList<LigneCommande> lignesCommande) {

        this.idCommande = idCommande;
        this.etatCommande = etatCommande;
        this.totalCommandeTTC = totalCommandeTTC;
        this.typeCommande = typeCommande;
        this.dateCommande = dateCommande;
        this.heureCommande = heureCommande;
        this.idUtilisateur = idUtilisateur;
        this.lignesCommande = lignesCommande;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Integer getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(Integer etatCommande) {
        this.etatCommande = etatCommande;
    }

    public Float getTotalCommandeTTC() {
        return totalCommandeTTC;
    }

    public void setTotalCommandeTTC(Float totalCommandeTTC) {
        this.totalCommandeTTC = totalCommandeTTC;
    }

    public String getTypeCommande() {
        return typeCommande;
    }

    public void setTypeCommande(String typeCommande) {
        this.typeCommande = typeCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getHeureCommande() {
        return heureCommande;
    }

    public void setHeureCommande(String heureCommande) {
        this.heureCommande = heureCommande;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public ArrayList<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(ArrayList<LigneCommande> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }
    
    
    public void afficher () {
    
        System.out.println("ID: " + idCommande);
        System.out.println("Etat: " + etatCommande);
        System.out.println("IdUtil: " + idUtilisateur);
        System.out.println("TypeCom: " + typeCommande);    
    }
    
    
    
}
