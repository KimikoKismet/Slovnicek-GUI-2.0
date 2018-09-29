package sample.selection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import sample.global.Constants;

import static sample.global.StaticVariables.nextStage;
import static sample.global.StaticVariables.nextStageForCreateVocabulary;
import static sample.global.StaticVariables.vocabularyName;
import static sample.global.StaticMethods.getLanguageList;
import static sample.global.StaticMethods.getPathToVocabulary;
import static sample.global.StaticMethods.getVocabularyList;
import static sample.fxml.Fxml.sceneLoader;


/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 28. 9. 2018
 * Time: 18:32
 */
public class SelectController {
    public ChoiceBox vocabularyList;
    public Button selectButton;
    public ChoiceBox languageList;
    public Button createVocabularyButton;

    @FXML
    public void initialize() {

        languageList.setItems(FXCollections.observableArrayList(getLanguageList()));
        languageList.setTooltip(new Tooltip("Select the language."));

        languageList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                vocabularyList.setItems(FXCollections.observableArrayList(getVocabularyList(newValue)));
                vocabularyList.getSelectionModel().selectFirst();
            }
        });

        languageList.getSelectionModel().selectFirst();


    }

    public void selectButtonAction() {
        vocabularyName = getPathToVocabulary( (String) languageList.getSelectionModel().getSelectedItem(), (String) vocabularyList.getSelectionModel().getSelectedItem() );
        sceneLoader(nextStage);
    }


    public void createVocabularyButtonAction() {
        sceneLoader(Constants.CREATE_FXML_FILE);
        nextStageForCreateVocabulary = Constants.SELECT_FXML_FILE;
    }

    public void backButtonAction() {
        sceneLoader(Constants.MENU_FXML_FILE);
    }
}
