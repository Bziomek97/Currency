package RepoCurrency.WebclientParse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Webclient {

    String RequireData(URL page){
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
        catch (Exception ignored){
        }
        return response.toString();
    }

}
