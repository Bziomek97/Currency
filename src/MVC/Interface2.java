package MVC;

import RepoCurrency.Currency;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Interface2 {

    private Calculator calc;

    @FXML private TextField KwotaIn;
    @FXML public ListView<String> Lista;

    @FXML
    private void initialize(){
        calc=new Calculator();

        ViewAll();
    }

    private void ViewAll(){
        System.out.println(Lista);
        ObservableList<String> list= FXCollections.observableArrayList();
        ArrayList<Currency> tmp=calc.getCurrList();
        for(Currency i: tmp) {
            list.add(i.getName()+" (KOD: "+i.getCode()+") Kurs:"+i.getRate());
        }
        Lista.setItems(list);
    }
}
