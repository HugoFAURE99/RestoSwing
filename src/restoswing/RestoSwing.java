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
        ListeCommandes liste = new ListeCommandes();
        liste.setVisible(true);
    }
    
}
