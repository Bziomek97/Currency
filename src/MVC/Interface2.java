package MVC;

import RepoCurrency.Currency;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class Interface2 {

    private Calculator calc;

    @FXML private TextField CountIn,CountOut,CodeIn,CodeOut;
    @FXML private Button Exchange;
    @FXML private ListView<String> Lista;

    @FXML
    private void initialize(){
        calc=new Calculator();
        ViewAll();
        exchange();
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

    private void exchange(){
        Exchange.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                CountOut.setText(String.valueOf(calc.Calculate(Double.parseDouble(CountIn.getText()),CodeIn.getText(),CodeOut.getText())));
            }
        });
    }

}
