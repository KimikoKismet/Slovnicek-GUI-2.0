package sample.examine;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import sample.global.Constants;
import sample.vocabulary.Vocabulary;

import static sample.fxml.Fxml.sceneLoader;
import static sample.global.StaticMethods.loadBackground;
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

    public Vocabulary vocabulary;
    public AnchorPane Pain;
    private String[] words;
    private int wordIndex;

    @FXML
    public void initialize() {
        loadBackground(Pain);
        
        vocabulary = new Vocabulary(vocabularyPath);
        words = vocabulary.examPreparation(wordCount);
        wordIndex = 0;
        String[] word = vocabulary.separation(words[wordIndex]);

        wordCountLabel.setText("" + wordCount);

        if (translationToNative) {
            wordForTranslate.setText(word[0]);
        } else {
            wordForTranslate.setText(word[1]);
        }
    }

    //TODO checkButtonAction()
    public void checkButtonAction() {
        check();
    }

    private boolean check() {
        String[] word = vocabulary.separation(words[wordIndex]);
        String foreignWord = word[0];
        String nativeWord = word[1];
        if (translationToNative) {
            return comparison(nativeWord);
        }
        else {
            return comparison(foreignWord);
        }
    }

    private boolean comparison(String comparingWord) {
        String answer = translationTextField.getText();
        if (answer.compareTo(comparingWord) == 0) {
            statusLabel.setText("OK. GOOD JOB.");
            return true;
        } else {
            statusLabel.setText("KO. TRY AGAIN.");
            return false;
        }
    }

    public void newExamButtonAction() {
        if (check()) {
            nextStage = Constants.EXAM_PREPARATION_FXML_FILE;
            sceneLoader(Constants.SELECT_FXML_FILE);
        } else {

        }
    }

    public void backButtonAction() {
        sceneLoader(Constants.MENU_FXML_FILE);
    }

    //TODO nextWordButtonAction()
    public void nextWordButtonAction() {
        wordIndex++;
        wordCountLabel.setText("" + (wordCount - wordIndex));
        String[] word = vocabulary.separation(words[wordIndex]);
        if (translationToNative) {
            wordForTranslate.setText(word[0]);
        } else {
            wordForTranslate.setText(word[1]);
        }
    }
}
