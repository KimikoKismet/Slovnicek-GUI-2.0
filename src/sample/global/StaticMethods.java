package sample.global;

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
        String path = (System.getProperty("user.dir")) + "\\Vocabulary\\" + language + "\\";
        return path;
    }

    public static String getPathToVocabulary(String language, String vocabularyName) {
        String path = (System.getProperty("user.dir")) + "\\Vocabulary\\" + language + "\\" + vocabularyName + ".txt";
        return path;
    }

    public static ArrayList<String> getLanguageList() {
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

    public static ArrayList<String> getVocabularyList(String name) {
        File CurrentDirectory = new File(System.getProperty("user.dir")+"\\Vocabulary\\" + name);
        String[] listOfTextFiles = CurrentDirectory.list();
        ArrayList<String> vocabularyList= new ArrayList<String>();
        for (String vocabularyName : listOfTextFiles) {
            vocabularyList.add(vocabularyName.substring(0,vocabularyName.length() - 4));
        }
        return vocabularyList;
    }

}
