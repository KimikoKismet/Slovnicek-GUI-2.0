package sample.create;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.global.Errors;

import java.io.File;

import static sample.global.StaticVariables.nextStageForCreateVocabulary;
import static sample.global.StaticMethods.getLanguageList;
import static sample.global.StaticMethods.getPathToVocabularyFolder;
import static sample.fxml.Fxml.sceneLoader;

/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 29. 9. 2018
 * Time: 12:24
 */
public class CreateVocabularyController {

    public Button createVocabularyButton;
    public Button backButton;
    public TextField nameOfVocabularyTextField;
    public ChoiceBox languageChoiceBox;

    @FXML
    private void initialize() {
        languageChoiceBox.setItems(FXCollections.observableArrayList(getLanguageList()));
        languageChoiceBox.setTooltip(new Tooltip("Select the language."));
        languageChoiceBox.getSelectionModel().selectFirst();
    }

    public void createVocabularyButtonAction() {
        if (!createNewTextFile(getPathToVocabularyFolder((String) languageChoiceBox.getSelectionModel().getSelectedItem())))  {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("File with named " + nameOfVocabularyTextField.getText() + ".txt could not be created. File named " + nameOfVocabularyTextField.getText() + ".txt already exists.");

            alert.showAndWait();
        }
    }

    private boolean createNewTextFile(String path) {
        File vocabulary = new File(path + nameOfVocabularyTextField.getText()+".txt");
        if (vocabulary.exists()) {
            return false;
        }
        try {
            vocabulary.createNewFile();
            return true;
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(Errors.ERROR_04.getHeaderText());
            alert.setContentText(Errors.ERROR_04.getContentText());

            alert.showAndWait();
            Platform.exit();

            return false;
        }
    }

    public void backButtonAction() {
        sceneLoader(nextStageForCreateVocabulary);
    }
}
