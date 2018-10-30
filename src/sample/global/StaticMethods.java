package sample.global;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import sample.Main;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 29. 9. 2018
 * Time: 22:03
 */
public class StaticMethods {

    public static String getPathToVocabularyFolder(String language) {
        String path = (Constants.PATH_TO_PROGRAM_FOLDER + "\\Vocabulary\\" + language + "\\");
        return path;
    }

    public static String getPathToVocabulary(String language, String vocabularyName) {
        String path = (Constants.PATH_TO_PROGRAM_FOLDER + "\\Vocabulary\\" + language + "\\" + vocabularyName + ".txt");
        return path;
    }

    public static ArrayList<String> getLanguageList() {
        File CurrentDirectory = new File(Constants.PATH_TO_PROGRAM_FOLDER + "\\Vocabulary");
        String[] listOfDirectories = CurrentDirectory.list();
        ArrayList<String> languageList= new ArrayList<String>();
        for(String name : listOfDirectories)
        {
            if (new File(Constants.PATH_TO_PROGRAM_FOLDER + "\\Vocabulary\\" + name).isDirectory())
            {
                languageList.add(name);
            }
        }
        return languageList;
    }

    /**
     *
     * @param name
     * @return
     */
    public static ArrayList<String> getVocabularyList(String name) {
        File CurrentDirectory = new File(Constants.PATH_TO_PROGRAM_FOLDER + "\\Vocabulary\\" + name);
        String[] listOfTextFiles = CurrentDirectory.list();
        ArrayList<String> vocabularyList= new ArrayList<String>();
        for (String vocabularyName : listOfTextFiles) {
            vocabularyList.add(vocabularyName.substring(0,vocabularyName.length() - 4));
        }
        return vocabularyList;
    }

    /**
     * vytvoří informační dialog
     * @param contentText informace, kterou chceme sdělit
     */
    public static void getInformationDialog(String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(Main.stage);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

    /**
     * načte pozadí ka danému oknu
     * @param Pain dané okno
     */
    public static void loadBackground(AnchorPane Pain) {
        Image image = loadImage("Background.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        Pain.setBackground(background);
    }

    /**
     * načte obrázek z daného souboru
     * @param nazevSouboru název souboru, kde se nachází obrázek
     * @return daný obrázek
     */
    public static Image loadImage(String nazevSouboru) {
        File file = new File(Constants.PATH_TO_PROGRAM_FOLDER + "\\Images\\" + nazevSouboru);
        Image image = new Image("file:/"+file.getAbsolutePath());
        return image;
    }

}
