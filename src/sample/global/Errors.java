package sample.global;

import javafx.scene.control.Alert;
import sample.Main;

/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 30. 9. 2018
 * Time: 0:40
 */
public enum Errors {
    ERROR_01 ("Error.01","Loading FXML file has failed."),
    ERROR_02 ("Error.02","Loading text file has failed."),
    ERROR_03 ("Error.03","Text file corrupted."),
    ERROR_04 ("Error.04","Creation of text file has failed.");

    private String headerText;
    private String contentText;

    Errors(String headerText, String contentText) {
        this.headerText = headerText;
        this.contentText = contentText;
    }

    public void getErrorDialog() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(Main.stage);
        alert.setTitle("Error");
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }
}
