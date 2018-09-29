package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/menu.fxml"));

        primaryStage.setTitle("Slovníček");
        primaryStage.setScene(new Scene(root,400, 400));
        primaryStage.setResizable(false);

        File icon =  new File(System.getProperty("user.dir")+"\\Images\\Icon.png");
        primaryStage.getIcons().add(new Image(icon.toURI().toString()));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
