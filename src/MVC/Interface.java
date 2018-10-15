package MVC;

import RepoCurrency.Currency;
import MVC.Controlling.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class Interface {

    private Calculator calc;

    @FXML private TextField CountIn,CountOut,CodeIn,CodeOut;
    @FXML private Button Exchange;
    @FXML private TableView<Currency> InfoTable;
    @FXML private TableColumn<Currency,String> CodeCol,NameCol,RateCol;
    @FXML private TableColumn<Currency,Integer> ConvCol;

    private SimpleStringProperty Code;
    private SimpleStringProperty Name;
    private SimpleIntegerProperty Conv;
    private SimpleStringProperty Rate;

    @FXML
    private void initialize(){
        calc=new Calculator();
        ViewAll();
        exchange();
    }

    private void ViewAll(){
        InfoTable.getColumns().clear();
        ObservableList<Currency> list= FXCollections.observableArrayList();
        ArrayList<Currency> tmp=calc.getCurrList();

        CodeCol.setCellValueFactory(new PropertyValueFactory<>("Code"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ConvCol.setCellValueFactory(new PropertyValueFactory<>("Converter"));
        RateCol.setCellValueFactory(new PropertyValueFactory<>("Rate"));

        list.addAll(tmp);
        InfoTable.setItems(list);
        InfoTable.getColumns().addAll(CodeCol,NameCol,ConvCol,RateCol);
        InfoTable.getSortOrder().add(NameCol);
    }

    private void exchange(){
        Exchange.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {

                digitController digit=new digitController();
                controlInteface curr=new currController();

                if(digit.check(CountIn.getText()) && curr.check(CodeIn.getText().toUpperCase()) && curr.check(CodeOut.getText().toUpperCase())) {
                    CountIn.setText(digit.point(CountIn.getText()));
                    CountOut.setText(String.valueOf(calc.Calculate(Double.parseDouble(CountIn.getText()),
                            CodeIn.getText().toUpperCase(), CodeOut.getText().toUpperCase())));
                }
                else{
                    CodeOut.clear();
                    CodeIn.clear();
                    CountIn.clear();
                    CodeOut.clear();
                }


            }
        });
    }

}

