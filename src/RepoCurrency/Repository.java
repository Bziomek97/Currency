package RepoCurrency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Repository {
    Map<String,Currency> map = new HashMap<String,Currency>();

    Repository(){
        // Here create a repo
    }

    // Get 1 item
    Currency getCurrByCode(String code){
        return map.get(code);
    }

    // Get whole item as List
    ArrayList<Currency> getCurrList(){
        ArrayList<Currency> arList = new ArrayList<Currency>();
        for(Map.Entry<String,Currency> m: map.entrySet()){
            arList.add(m.getValue());
        }

        return arList;
    }
}
