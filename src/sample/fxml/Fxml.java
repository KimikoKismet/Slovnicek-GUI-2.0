package sample.fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;

/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 28. 9. 2018
 * Time: 19:43
 */
public class Fxml {
    public static void sceneLoader(String soubor) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Fxml.class.getResource(soubor));
        Parent root = fxmlLoader.load();
        Main.stage.setScene(new Scene(root, 400, 400));
        Main.stage.show();
    }
}
