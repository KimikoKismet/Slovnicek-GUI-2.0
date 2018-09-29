package sample.menu;

import javafx.application.Platform;
import javafx.scene.control.Button;
import sample.Constants;
import static sample.staticUse.StaticVariables.nextStage;
import static sample.staticUse.StaticVariables.nextStageForCreateVocabulary;
import static sample.fxml.Fxml.sceneLoader;


public class MenuController {
    public Button exitButton;
    public Button showVocabularyButton;
    public Button examineYourselfButton;
    public Button addWordButton;
    public Button createVocabularyButton;

    //TODO výběr jazyku programu

    public void addWordButtonAction() {
        sceneLoader(Constants.SELECT_FXML_FILE);
        nextStage = Constants.ADD_FXML_FILE;
    }

    public void showVocabularyButtonAction() {
        sceneLoader(Constants.SELECT_FXML_FILE);
        nextStage = Constants.SHOW_FXML_FILE;
    }

    public void examineYourselfButtonAction() {
        sceneLoader(Constants.SELECT_FXML_FILE);
        nextStage = Constants.EXAM_PREPARATION_FXML_FILE;
    }

    public void createVocabularyButtonAction() {
        sceneLoader(Constants.SELECT_FXML_FILE);
        nextStageForCreateVocabulary = Constants.MENU_FXML_FILE;
    }

    public void exitButtonAction() { Platform.exit(); }
}
