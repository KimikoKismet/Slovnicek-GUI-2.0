package sample.examine;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import sample.global.Constants;

import static sample.fxml.Fxml.sceneLoader;
import static sample.global.StaticMethods.loadBackground;
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
    public AnchorPane Pain;

    public void initialize() {
        loadBackground(Pain);
    }

    public void foreignToNativeButtonAction() {
        translationToNative = true;
        wordCount = Integer.parseInt(wordCountTextField.getText());
        sceneLoader(Constants.EXAMINE_FXML_FILE);
    }

    public void nativeToForeignButtonAction() {
        translationToNative = false;
        wordCount = Integer.parseInt(wordCountTextField.getText());
        sceneLoader(Constants.EXAMINE_FXML_FILE);
    }
}
