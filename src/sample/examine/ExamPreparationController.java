package sample.examine;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.global.Constants;

import static sample.fxml.Fxml.sceneLoader;
import static sample.global.StaticVariables.*;

/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 28. 9. 2018
 * Time: 18:33
 */
public class ExamPreparationController {

    public Button foreignToNativeButton;
    public Button nativeToForeignButton;
    public TextField wordCountTextField;

    public void foreignToNativeButtonAction() {
        translationToForeign = true;
        sceneLoader(Constants.EXAMINE_FXML_FILE);
        wordCount = Integer.parseInt(wordCountTextField.getText());
    }

    public void nativeToForeignButtonAction() {
        translationToForeign = false;
        sceneLoader(Constants.EXAMINE_FXML_FILE);
        wordCount = Integer.parseInt(wordCountTextField.getText());
    }
}
