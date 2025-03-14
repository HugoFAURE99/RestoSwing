/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restoswing;

/**
 *
 * @author Hugo
 */
public class LigneCommande {
    
    private Integer idCommande;
    private Integer idProduit;
    private Integer qteLigne;
    private Float totalLigneHT;

    public LigneCommande( Integer idCommande, Integer idProduit, Integer qteLigne, Float totalLigneHT) {

        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.qteLigne = qteLigne;
        this.totalLigneHT = totalLigneHT;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getQteLigne() {
        return qteLigne;
    }

    public void setQteLigne(Integer qteLigne) {
        this.qteLigne = qteLigne;
    }

    public Float getTotalLigneHT() {
        return totalLigneHT;
    }

    public void setTotalLigneHT(Float totalLigneHT) {
        this.totalLigneHT = totalLigneHT;
    }
    
    public void afficher () {
    
        System.out.println("idPro:  " + idProduit);
        System.out.println("qte: " + qteLigne);
    }

}
