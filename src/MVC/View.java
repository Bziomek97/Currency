package MVC;

import RepoCurrency.Repository;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Interface.fxml"));
        primaryStage.setScene(new Scene(loader, 583, 193));
        primaryStage.show();

    }
}
