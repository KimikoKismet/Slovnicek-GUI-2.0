package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/menu.fxml"));
        primaryStage.setTitle("Slovníček");
        primaryStage.setScene(new Scene(root,400, 400));
        primaryStage.getIcons().add(new Image("https://cdn2.iconfinder.com/data/icons/translation-1/513/translation-translate-language-international-translating_2_copy_13-512.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
