package sample.selection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import sample.global.Constants;

import static sample.fxml.Fxml.sceneLoader;
import static sample.global.StaticMethods.*;
import static sample.global.StaticVariables.*;


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
    public AnchorPane Pain;

    @FXML
    public void initialize() {
        loadBackground(Pain);

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
        vocabularyName = vocabularyList.getSelectionModel().getSelectedItem() + ".txt";
        vocabularyPath = getPathToVocabulary( (String) languageList.getSelectionModel().getSelectedItem(), (String) vocabularyList.getSelectionModel().getSelectedItem() );
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
