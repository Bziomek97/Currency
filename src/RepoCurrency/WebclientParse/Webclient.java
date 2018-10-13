package RepoCurrency.WebclientParse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Webclient {

    void RequireData(URL page) {
        try {
            HttpURLConnection con = (HttpURLConnection) page.openConnection();
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
