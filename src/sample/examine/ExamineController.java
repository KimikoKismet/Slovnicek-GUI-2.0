package sample.examine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.global.Constants;
import sample.vocabulary.Vocabulary;

import static sample.fxml.Fxml.sceneLoader;
import static sample.global.StaticVariables.*;

/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 28. 9. 2018
 * Time: 21:40
 */
public class ExamineController {

    public Label wordCountLabel;
    public Label wordForTranslate;
    public Button checkButton;
    public TextField translationTextField;
    public Label statusLabel;

    private Vocabulary vocabulary;
    private String[] words;
    private int wordIndex;

    @FXML
    public void initialize() {
        vocabulary = new Vocabulary(vocabularyName);
        words = vocabulary.examPreparation(wordCount);
        wordIndex = 0;
        String[] word = vocabulary.separation(words[wordIndex]);

        wordCountLabel.setText("" + wordCount);

        if (translationToForeign) {
            wordForTranslate.setText(word[0]);
        } else {
            wordForTranslate.setText(word[1]);
        }
    }

    //TODO checkButtonAction()
    public void checkButtonAction() {
        String answer = translationTextField.getText();
        String[] word = vocabulary.separation(words[wordIndex]);
        String foreignWord = word[0];
        String nativeWord = word[1];
        if (translationToForeign) {
            if (answer.compareTo(nativeWord) == 0) {
                statusLabel.setText("OK. GOOD JOB.");
            } else {
                statusLabel.setText("KO. TRY AGAIN.");
            }
        }
        else {
            if (answer.compareTo(foreignWord) == 0) {
                statusLabel.setText("OK. GOOD JOB.");
            } else {
                statusLabel.setText("KO. TRY AGAIN.");
            }
        }
    }

    public void newExamButtonAction() {
        nextStage = Constants.EXAM_PREPARATION_FXML_FILE;
        sceneLoader(Constants.SELECT_FXML_FILE);
    }

    public void backButtonAction() {
        sceneLoader(Constants.MENU_FXML_FILE);
    }

    //TODO nextWordButtonAction()
    public void nextWordButtonAction() {
        wordIndex++;
        wordCountLabel.setText("" + (wordCount - wordIndex));
        String[] word = vocabulary.separation(words[wordIndex]);
        if (translationToForeign) {
            wordForTranslate.setText(word[0]);
        } else {
            wordForTranslate.setText(word[1]);
        }
    }
}
