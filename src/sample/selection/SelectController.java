package sample.selection;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;


import static sample.Static.nextStage;
import static sample.fxml.Fxml.sceneLoader;


/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 28. 9. 2018
 * Time: 18:32
 */
public class SelectController {
    public ChoiceBox VocabularyList;
    public Button SelectButton;

    public void SelectButtonAction() throws Exception {
        sceneLoader(nextStage);
    }
}
