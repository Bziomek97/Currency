package RepoCurrency.WebclientParse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Webclient {

    String RequireData(URL page) {
        StringBuffer response = new StringBuffer();
        try {
            HttpURLConnection con = (HttpURLConnection) page.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return response.toString();
    }

}
