package sample.fxml;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import sample.global.Errors;
import sample.Main;

/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 28. 9. 2018
 * Time: 19:43
 */
public class Fxml {

    public static void sceneLoader(String soubor)  {
        FXMLLoader fxmlLoader = new FXMLLoader(Fxml.class.getResource(soubor));
        try {
            Parent root = fxmlLoader.load();
            Main.stage.setScene(new Scene(root));
            Main.stage.show();

        } catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(Errors.ERROR_01.getHeaderText());
            alert.setContentText(Errors.ERROR_01.getContentText());

            alert.showAndWait();

            Platform.exit();
        }

    }
}
