package RepoCurrency.WebclientParse;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ParseFromCSV implements InterfaceParse {

    @Override
    public ArrayList<String> Parse() {
        ArrayList<String> tmp = new ArrayList<>();
        String csvFile = System.getProperty("user.dir") + "/src/convertcsv.csv";
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            String line;
            while ((line = br.readLine()) != null) {

                String[] curr = line.split(";");
                curr[3]=curr[3].replace(",",".");
                tmp.addAll(Arrays.asList(curr));

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tmp;
    }
}
