package sample.add;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import sample.global.Constants;
import sample.vocabulary.Vocabulary;

import static sample.global.StaticMethods.loadBackground;
import static sample.global.StaticVariables.vocabularyPath;
import static sample.fxml.Fxml.sceneLoader;

/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 28. 9. 2018
 * Time: 20:27
 */
public class AddController {
    public Button AddWordButton;
    public Button BackButton;
    public Button ChangeVocabularyButton;
    public TextField ForeignLanguageText;
    public TextField NativeLanguageText;
    public AnchorPane Pain;

    public void initialize() {
        loadBackground(Pain);
    }
    
    public void AddWordButtonAction() {
        addWord();
    }

    private void addWord() {
        Vocabulary vocabulary = new Vocabulary(vocabularyPath);
        String word = ForeignLanguageText.getText() + " - " + NativeLanguageText.getText();
        if ((ForeignLanguageText.getText().length() > 1) && (NativeLanguageText.getText().length() > 0)) {
            if (vocabulary.enterWord(word)) {
                ForeignLanguageText.setText("");
                NativeLanguageText.setText("");
            } else {

            }
        }
    }

    public void BackButtonAction() throws Exception {
        sceneLoader(Constants.MENU_FXML_FILE);
    }

    public void ChangeVocabularyButtonAction() throws Exception {
        sceneLoader(Constants.SELECT_FXML_FILE);
    }
}
