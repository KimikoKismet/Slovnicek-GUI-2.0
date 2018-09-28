package sample.menu;

import javafx.application.Platform;
import javafx.scene.control.Button;
import sample.Constants;
import static sample.Static.nextStage;
import static sample.fxml.Fxml.sceneLoader;


public class MenuController {
    public Button ShowVocabularyButton;
    public Button ExamineYourselfButton;
    public Button ExitButton;
    public Button AddWordButton;


    public void ShowVocabularyButtonAction() throws Exception {
        sceneLoader(Constants.SELECT_FXML_SOUBOR);
        nextStage = Constants.SHOW_FXML_SOUBOR;
    }

    public void ExamineYourselfButtonAction() throws Exception {
        sceneLoader(Constants.SELECT_FXML_SOUBOR);
        nextStage = Constants.EXAM_PREPARATION_FXML_SOUBOR;
    }

    public void AddWordButtonAction() throws Exception {
        sceneLoader(Constants.SELECT_FXML_SOUBOR);
        nextStage = Constants.ADD_FXML_SOUBOR;
    }

    public void ExitButtonAction() { Platform.exit(); }


}
