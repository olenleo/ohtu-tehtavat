package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import java.util.Date;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        Arrays.sort(players);
        
        System.out.println("Players from FIN : " + date );

        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                System.out.println(player);
            }
        }
        
        
    }

  
}
