/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restoswing;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Hugo
 */
public class ListeCommandes extends javax.swing.JFrame {

    /**
     * Creates new form ListeCommandes
     */
    
    //System.out.println(commandes_json.length());
    ArrayList<Commande> les_commandes = new ArrayList<>();
    
    //Parsing du JSON venant de l'api "commandes_en_attente"
    public void get_data(){
    
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
        
        
        //Alimentation de la collection de commande et des lignes commandes d"une commande
        for (int i=0; i < commandes_json.length(); i++ ) {
            //Commandes
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
            
            //Lignes commandes
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
           
        }
        
        //Affichage et création de la JTABLE
        String[] colonnes = new String[]{"ID","Date", "Heure", "Etat","Nb pdts", "Montant"}; // Tableau des entetes
        
        Object[][] data = new Object [les_commandes.size()][6]; // Declaration du talbeau à 2 dimensions qui va alimenter les valeurs de la JTABLE
        
        //Pour chaque commandes on set la valeurs au bon endroit dans le tableaux
        for(int i= 0; i<les_commandes.size(); i++ ) {
        
        data[i][0] = les_commandes.get(i).getIdCommande();
        data[i][1] = les_commandes.get(i).getDateCommande();
        data[i][2] = les_commandes.get(i).getHeureCommande();
        data[i][3] = les_commandes.get(i).getEtatCommande();
        data[i][4] = les_commandes.get(i).getLignesCommande().size();
        data[i][5] = les_commandes.get(i).getTotalCommandeTTC();
        }
        
        //Recuperation avec le jTable qu'on a créer avec le design
        JTable table = jTable1;
        
        //On recrée un model et on le passe au Jtable pour que la table se mette à jour
        DefaultTableModel model = new DefaultTableModel(data,colonnes) {
            @Override
            public boolean isCellEditable(int row, int column){
                //rend toutes les cellules non édtibales, en ecrasant l'ancienne méthodes
                return false;
            }
        }; // Model qui se base sur nos tableaux
        table.setModel(model); // On passe le modele a notre vrai Jtable
        
    
    };
    
    public ListeCommandes() {
        initComponents(); // Fait par Netbeans, initialise tous les composants que l'on a mis dans la fenetre design
        get_data(); //Permet d'executer le parsing a chaque instanciation de la classe
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setEditingColumn(0);
        jTable1.setEditingRow(0);
        jTable1.setRowHeight(30);
        jTable1.setRowSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Liste des Commandes");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(304, 304, 304))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(418, 418, 418))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Code qui défni ce qui va se passer quand on clique sur le bouton
        
        int row = jTable1.getSelectedRow();
        
        if (row >= 0 && row < jTable1.getRowCount) {
            Commande commande = les_commandes.get(row);
           
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListeCommandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListeCommandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListeCommandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListeCommandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListeCommandes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
