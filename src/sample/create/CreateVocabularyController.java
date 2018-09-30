package sample.create;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import sample.global.Errors;

import java.io.File;

import static sample.global.StaticMethods.*;
import static sample.global.StaticVariables.nextStageForCreateVocabulary;
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
    public AnchorPane Pain;

    @FXML
    private void initialize() {
        loadBackground(Pain);
        
        languageChoiceBox.setItems(FXCollections.observableArrayList(getLanguageList()));
        languageChoiceBox.setTooltip(new Tooltip("Select the language."));
        languageChoiceBox.getSelectionModel().selectFirst();
    }

    public void createVocabularyButtonAction() {
        if (createNewTextFile(getPathToVocabularyFolder((String) languageChoiceBox.getSelectionModel().getSelectedItem())))  {
            getInformationDialog("File named " + nameOfVocabularyTextField.getText() + ".txt has been successfully created.");
            nameOfVocabularyTextField.setText("");
        } else {
            getInformationDialog("File named " + nameOfVocabularyTextField.getText() + ".txt could not be created. File named " + nameOfVocabularyTextField.getText() + ".txt already exists.");
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
            e.printStackTrace();
            Errors.ERROR_04.getErrorDialog();
            return false;
        }
    }

    public void backButtonAction() {
        sceneLoader(nextStageForCreateVocabulary);
    }
}
