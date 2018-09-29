package sample.vocabulary;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by IntelliJ IDEA.
 * User: Kimiko
 * Date: 29. 9. 2018
 * Time: 23:58
 */
public class Word {
    private SimpleStringProperty foreignWord;
    private SimpleStringProperty nativeWord;

    public Word(String foreignWord, String nativeWord) {
        this.foreignWord = new SimpleStringProperty(foreignWord);
        this.nativeWord = new SimpleStringProperty(nativeWord);
    }

    public String getForeignWord() {
        return foreignWord.get();
    }

    public String getNativeWord() {
        return nativeWord.get();
    }

}