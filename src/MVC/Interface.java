package MVC;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Interface extends Application {


    public static void main(String[] args) {
        launch(Interface.class,args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("Interface.fxml"));
            root = loader.load();
            primaryStage.setScene(new Scene(root, 600, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.show();

    }

}


