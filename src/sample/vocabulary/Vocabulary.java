package sample.vocabulary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
//TODO upravit celou tuto tridu
/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 28. 9. 2018
 * Time: 20:37
 */
public class Vocabulary {
    private String fileName;
    private BufferedReader br;
    private String line;


    /**
     * konstruktor třídy Slovníček
     * @param fileName název slovníčku
     */
    public Vocabulary(String fileName){
        this.fileName = fileName;
    }

    /**
     * vypíše slovíčko do slovníčku
     * @param word slovíčko, které chceme vypsat do slovníčku
     */
    public void enterWord(String word) throws Exception {
        FileWriter fw;
        fw = new FileWriter(fileName, true);
        fw.write(word+"\n");
        fw.flush();
        fw.close();
    }

    public ArrayList<String> viewVocabulary() {
        BufferedReader br;                  // Trida usnadnujici cteni ze souboru, ale pro pouziti potrebuje jeste nejakou tridu Reader jako je FileReader
        ArrayList<String> vocabulary = new ArrayList<>();
        try{
            br = new BufferedReader(new FileReader(fileName)); //Vytvoreni instance tridy BufferedReader, ktery pro cteni ze souboru bude pouzivat instanci tridy FileReader
            String line;
            while ((line=br.readLine())!=null) {
                vocabulary.add(line);
            }
            br.close();
        }catch (Exception e){

        }
        return vocabulary;
    }

    public String[] examPreparation(int wordCount) throws Exception {
        String[] exam = new String[wordCount];
        for (int j = 0; j<wordCount; j++) {
            int x = (int)(Math.random()*getWordCountInVocabulary());
            exam[j] = getExamListOfVocabulary()[x];
        }
        return exam;
    }

    public int getWordCountInVocabulary() throws Exception {
        br = new BufferedReader(new FileReader(fileName));
        int wordCountInVocabulary = 0;

        while ((line=br.readLine())!=null) {
            wordCountInVocabulary++;
        }

        br.close();

        return wordCountInVocabulary;
    }

    public String[] getExamListOfVocabulary() throws Exception {
        String[] words = new String[getWordCountInVocabulary()];
        int i = 0;

        br = new BufferedReader(new FileReader(fileName));
        while ((line=br.readLine())!=null) {
            words[i] = line;
            i++;
        }
        br.close();

        return words;
    }

    public String[] Separation(String word) {
        String[] result = word.split(" ");
        return result;
    }
}
