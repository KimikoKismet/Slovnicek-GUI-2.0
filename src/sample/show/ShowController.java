package sample.show;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.global.Constants;
import sample.global.Errors;
import sample.vocabulary.Vocabulary;
import sample.vocabulary.Word;

import java.util.ArrayList;
import java.util.List;

import static sample.fxml.Fxml.sceneLoader;
import static sample.global.StaticVariables.vocabularyName;

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

    @FXML
    private void initialize() {
        ArrayList<String> wordsList;
        Vocabulary vocabulary = new Vocabulary(vocabularyName);
        wordsList = vocabulary.viewVocabulary();
        List list = new ArrayList();

        foreignTableCol.setCellValueFactory(new PropertyValueFactory("foreignWord"));
        nativeTableCol.setCellValueFactory(new PropertyValueFactory("nativeWord"));

        for (String word : wordsList) {
            String[] words = vocabulary.separation(word);
            try {
                list.add(new Word(words[0], words[1]));
            } catch (IndexOutOfBoundsException e ) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(Errors.ERROR_03.getHeaderText());
                alert.setContentText(Errors.ERROR_03.getContentText());

                alert.showAndWait();

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
