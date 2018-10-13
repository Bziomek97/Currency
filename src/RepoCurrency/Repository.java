package RepoCurrency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Repository {
    Map<String,Currency> map = new HashMap<>();

    Repository(){
        // Here create a repo

    }

    // Get 1 item
    Currency getCurrByCode(String code){
        return this.map.get(code);
    }

    // Get whole item as List
    ArrayList<Currency> getCurrList(){
        ArrayList<Currency> arList = new ArrayList<Currency>();
        for(Map.Entry<String,Currency> m: this.map.entrySet()){
            arList.add(m.getValue());
        }

        return arList;
    }
}
