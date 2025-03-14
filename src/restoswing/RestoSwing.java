/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restoswing;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author Hugo
 */
public class RestoSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String json = ""; // Le JSON brut
        String url =
        "http://localhost/projets/restoweb/restoweb/api/commandes_en_attente.php";
        // Créer un HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // Crée une requête HTTP GET
        try {
        // Construit l'URL de la requête
        HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI(url))
        .build();
        // Envoie la requête et attend la réponse
        HttpResponse<String> response = client.send(request,
        HttpResponse.BodyHandlers.ofString());
        // Vérifie que la réponse est normale
        if (response.statusCode() == 200) {
        json = response.body();
        } else {
        System.err.println("Erreur : Code statut " + response.statusCode());
        }
        } catch (Exception ex) {
        System.err.println("Erreur : " + ex.getMessage());
        //ex.printStackTrace();
        }
        //System.out.println(json); //Ici on a le JSON brut
        
        
        JSONArray commandes_json = new JSONArray(json); //On a mtn un tableau JSON
        
        //System.out.println(commandes_json.length());
        ArrayList<Commande> les_commandes = new ArrayList<>();
        
        
        
        for (int i=0; i < commandes_json.length(); i++ ) {
            
           try{
            JSONObject commande = commandes_json.getJSONObject(i);
            
            
            Integer id_com = commande.getInt("idCommande");
            Integer etat_com = commande.getInt("etatCommande");
            Float totalTTC_com = commande.getFloat("totalCommandeTTC");
            String type_com = commande.getString("typeCommande");
            String date_com = commande.getString("dateCommande");
            String heure_com = commande.getString("heureCommande");
            Integer idUtil_com = commande.getInt("idUtilisateur");
            JSONArray lignesCom_com = commande.getJSONArray("lignesCommande");
            
            //Gestion des lignes commandes
            ArrayList les_lignes = new ArrayList<>();
            
            for (int k=0; k<lignesCom_com.length(); k++) {
            
               JSONObject ligneCom =  lignesCom_com.getJSONObject(k);
               
               Integer idCom_ligne = ligneCom.getInt("idCom");
               Integer idPro_ligne = ligneCom.getInt("idProduit");
               Integer qte_ligne = ligneCom.getInt("qteLigne");
               Float totalHt_ligne = ligneCom.getFloat("totalLigneHT");
               
               LigneCommande une_ligne = new LigneCommande(idCom_ligne, idPro_ligne,qte_ligne,totalHt_ligne);
               les_lignes.add(une_ligne);
            }

                        
            
       
            
            Commande une_commande = new Commande(id_com, etat_com, totalTTC_com, type_com, date_com, heure_com, idUtil_com,les_lignes);
            les_commandes.add(une_commande);
            
           } catch(JSONException ex){
              String message =  ex.getMessage();
               
               System.err.println("Erreur lors du parsage du JSON OBJECT: " + message);
           }
           
           for(int j=0; j<les_commandes.size(); j++){
                
                les_commandes.get(j).afficher();
                System.out.println("--------");
                
                ArrayList<LigneCommande> ligneListe_com = les_commandes.get(j).getLignesCommande();
                
                for (int l = 0; l < ligneListe_com.size(); l ++ ){
                    
                    ligneListe_com.get(l).afficher();
                    System.out.println("--------");
                }
                
                System.out.println("==============");
            }
        }
    }
    
}
