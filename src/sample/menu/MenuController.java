package sample.menu;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import sample.global.Constants;

import static sample.global.StaticMethods.loadBackground;
import static sample.global.StaticVariables.nextStage;
import static sample.global.StaticVariables.nextStageForCreateVocabulary;
import static sample.fxml.Fxml.sceneLoader;


public class MenuController {
    public Button exitButton;
    public Button showVocabularyButton;
    public Button examineYourselfButton;
    public Button addWordButton;
    public Button createVocabularyButton;
    public AnchorPane Pain;

    //TODO výběr jazyku programu

    public void initialize() {
        loadBackground(Pain);
    }

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
        sceneLoader(Constants.CREATE_FXML_FILE);
        nextStageForCreateVocabulary = Constants.MENU_FXML_FILE;
    }

    public void exitButtonAction() { Platform.exit(); }
}
