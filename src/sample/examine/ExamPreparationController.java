package sample.examine;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Constants;
import sample.vocabulary.Vocabulary;

import static sample.Static.typeOfExam;
import static sample.Static.vocabularyName;
import static sample.Static.words;
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

    public void languageToForeignButtonAction() throws Exception {
        Vocabulary vocabulary = new Vocabulary(vocabularyName);
        words = vocabulary.examPreparation(Integer.parseInt(wordCount.getText()));
        typeOfExam = "FLtoNL";
        sceneLoader(Constants.EXAMINE_FXML_SOUBOR);
    }

    public void nativeToForeignButtonAction() throws Exception{
        Vocabulary vocabulary = new Vocabulary(vocabularyName);
        words = vocabulary.examPreparation(Integer.parseInt(wordCount.getText()));
        typeOfExam = "NLtoFL";
        sceneLoader(Constants.EXAMINE_FXML_SOUBOR);
    }
}
