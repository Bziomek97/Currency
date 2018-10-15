package RepoCurrency;

import RepoCurrency.WebclientParse.InterfaceParse;
import RepoCurrency.WebclientParse.ParseFromCSV;
import RepoCurrency.WebclientParse.ParseFromXML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Map<String,Currency> map = new HashMap<>();

    public Repository(){
        // Here create View repo
        ArrayList<String> information;

        // if connect do this else download data from CSV or other source of currency data

        InterfaceParse xml= new ParseFromXML();
        information=xml.Parse();

        for(int i=0; i<(information.size()/4);i++){

            int tmpdigit= Integer.parseInt(information.get((i*4)+1));
            double tmpdouble =  Double.parseDouble(information.get((i * 4) + 3));

            Currency tmp = new Currency();
            tmp.setName(information.get(i*4));
            tmp.setConverter(tmpdigit);
            tmp.setCode(information.get((i*4)+2));
            tmp.setRate(tmpdouble);
            map.put(information.get((i*4)+2),tmp);
        }

        Currency tmp = new Currency();
        tmp.setName("złoty polski");
        tmp.setConverter(1);
        tmp.setCode("PLN");
        tmp.setRate(1);
        map.put("PLN",tmp);

    }

    // Get 1 item
    public Currency getCurrByCode(String code){
        return this.map.get(code);
    }

    // Get whole item as List
    public ArrayList<Currency> getCurrList(){
        ArrayList<Currency> arList = new ArrayList<>();
        for(Map.Entry<String,Currency> m: this.map.entrySet()){
            arList.add(m.getValue());
        }

        return arList;
    }
}
