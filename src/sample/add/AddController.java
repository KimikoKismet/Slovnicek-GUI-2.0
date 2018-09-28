package sample.add;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Constants;
import sample.vocabulary.Vocabulary;

import static sample.Static.vocabularyName;
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


    public void AddWordButtonAction() throws Exception {
        addWord();
    }

    private void addWord() throws Exception {
        Vocabulary vocabulary = new Vocabulary(vocabularyName);
        String word = ForeignLanguageText.getText() + " " + NativeLanguageText.getText();
        if ((ForeignLanguageText.getText().length() > 1) && (NativeLanguageText.getText().length() > 0)) {
            vocabulary.enterWord(word);
            ForeignLanguageText.setText("");
            NativeLanguageText.setText("");
        }
    }

    public void BackButtonAction() throws Exception {
        sceneLoader(Constants.MENU_FXML_SOUBOR);
    }

    public void ChangeVocabularyButtonAction() throws Exception {
        sceneLoader(Constants.SELECT_FXML_SOUBOR);
    }
}
