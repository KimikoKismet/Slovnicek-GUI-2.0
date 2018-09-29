package sample.selection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import sample.vocabulary.Vocabulary;


import java.io.File;
import java.util.ArrayList;

import static sample.Static.nextStage;
import static sample.Static.vocabularyName;
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
    public ChoiceBox LanguageList;

    @FXML
    public void initialize() {

        LanguageList.setItems(FXCollections.observableArrayList(getLanguageList()));
        LanguageList.setTooltip(new Tooltip("Select the language."));

        LanguageList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                VocabularyList.setItems(FXCollections.observableArrayList(getVocabularyList(newValue)));
                VocabularyList.getSelectionModel().selectFirst();
            }
        });

        LanguageList.getSelectionModel().selectFirst();


    }

    private ArrayList<String> getVocabularyList(String name) {
        File CurrentDirectory = new File(System.getProperty("user.dir")+"\\Vocabulary\\" + name);
        String[] listOfTextFiles = CurrentDirectory.list();
        ArrayList<String> vocabularyList= new ArrayList<String>();
        for (String vocabularyName : listOfTextFiles) {
            vocabularyList.add(vocabularyName.substring(0,vocabularyName.length() - 4));
        }
        return vocabularyList;
    }

    private ArrayList<String> getLanguageList() {
        File CurrentDirectory = new File(System.getProperty("user.dir")+"\\Vocabulary");
        String[] listOfDirectories = CurrentDirectory.list();
        ArrayList<String> languageList= new ArrayList<String>();
        for(String name : listOfDirectories)
        {
            if (new File(System.getProperty("user.dir")+"\\Vocabulary\\" + name).isDirectory())
            {
                languageList.add(name);
            }
        }
        return languageList;
    }

    public void SelectButtonAction() {
        vocabularyName = System.getProperty("user.dir")+"\\Vocabulary\\" + ((String) LanguageList.getSelectionModel().getSelectedItem()) + "\\" + ((String) VocabularyList.getSelectionModel().getSelectedItem()) + ".txt";
        sceneLoader(nextStage);
    }


}
