package MVC;

import RepoCurrency.Currency;
import RepoCurrency.Repository;

import java.util.ArrayList;
import java.util.Map;

public class Calculator {

    private Repository Rep;

    public Calculator(){
        Rep= new Repository();
    }

    public double Calculate(double Count, String Cur1, String Cur2){
        double tmp=0;
        tmp=Count*(getCurrByCode(Cur1).getRate()/getCurrByCode(Cur1).getConverter());
        return tmp*(getCurrByCode(Cur2).getConverter()/getCurrByCode(Cur2).getRate());
    }

    private Currency getCurrByCode(String Code){
        return Rep.getCurrByCode(Code);
    }

    public ArrayList<Currency> getCurrList(){
        return Rep.getCurrList();
    }
}
