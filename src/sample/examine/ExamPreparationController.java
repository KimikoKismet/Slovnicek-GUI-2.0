package sample.examine;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.global.Constants;
import sample.vocabulary.Vocabulary;

import static sample.global.StaticVariables.typeOfExam;
import static sample.global.StaticVariables.vocabularyName;
import static sample.global.StaticVariables.words;
import static sample.fxml.Fxml.sceneLoader;

/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 28. 9. 2018
 * Time: 18:33
 */
public class ExamPreparationController {

    public Button foreignToNativeButton;
    public Button nativeToForeignButton;
    public TextField wordCount;

    public void languageToForeignButtonAction() {
        Vocabulary vocabulary = new Vocabulary(vocabularyName);
        words = vocabulary.examPreparation(Integer.parseInt(wordCount.getText()));
        typeOfExam = "FLtoNL";
        sceneLoader(Constants.EXAMINE_FXML_FILE);
    }

    public void nativeToForeignButtonAction() throws Exception{
        Vocabulary vocabulary = new Vocabulary(vocabularyName);
        words = vocabulary.examPreparation(Integer.parseInt(wordCount.getText()));
        if (words.length == 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error.02");
            alert.setContentText("");

            alert.showAndWait();
            Platform.exit();
            Platform.exit();
        }
        typeOfExam = "NLtoFL";
        sceneLoader(Constants.EXAMINE_FXML_FILE);
    }
}
