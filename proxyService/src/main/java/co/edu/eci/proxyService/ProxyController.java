/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.eci.proxyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ProxyController {
    private static final String USER_AGENT = "Mozilla/5.0";

    @GetMapping("/pellseq")
    public ResponseEntity<?> pellService(@RequestParam int value) throws Exception{
        
    
        
    List<Integer> sec = new ArrayList<>();

    String res = "";
    
    try{
        System.out.println("intento instancia 1");
        res = HttpConnection("http://34.232.145.79:8080/pell?value="+value);
        
    }catch(Exception e){
        System.out.println("1 no responde");
        System.out.println("intento instancia 2");
        res = HttpConnection("http://52.22.228.202:8080/pell?value="+value);

    }
        

    
        return ResponseEntity.status(200).body(res);
    }

    
    public static String HttpConnection(String GET_URL) throws Exception {

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();

        } else {
            System.out.println("servidor caido, redirigir");
            throw new Exception("servidor caido");
        }
        
    }
}
