package sample.show;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import sample.global.Constants;
import sample.global.Errors;
import sample.vocabulary.Vocabulary;
import sample.vocabulary.Word;

import java.util.ArrayList;
import java.util.List;

import static sample.fxml.Fxml.sceneLoader;
import static sample.global.StaticMethods.loadBackground;
import static sample.global.StaticVariables.vocabularyPath;

/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 28. 9. 2018
 * Time: 19:11
 */
public class ShowController {
    public TableColumn nativeTableCol;
    public TableColumn foreignTableCol;
    public Button backButton;
    public Label wordCountLabel;
    public TableView table;
    public AnchorPane Pain;

    //TODO wordcount

    @FXML
    private void initialize() {
        loadBackground(Pain);

        ArrayList<String> wordsList;
        Vocabulary vocabulary = new Vocabulary(vocabularyPath);
        wordsList = vocabulary.viewVocabulary();
        List list = new ArrayList();

        foreignTableCol.setCellValueFactory(new PropertyValueFactory("foreignWord"));
        nativeTableCol.setCellValueFactory(new PropertyValueFactory("nativeWord"));

        for (String word : wordsList) {
            String[] words = vocabulary.separation(word);
            try {
                list.add(new Word(words[0], words[1]));
            } catch (IndexOutOfBoundsException e ) {
                Errors.ERROR_03.getErrorDialog();
                list = new ArrayList();
                break;
            }
        }

        table.setItems(FXCollections.observableList(list));
    }

    public void backButtonAction() {
        sceneLoader(Constants.MENU_FXML_FILE);
    }
}
