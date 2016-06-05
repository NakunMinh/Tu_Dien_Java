/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_tap_02;

/**
 *
 * @author Minh Nhi
 */
public class Record {

    public Record() {
    }

    public Record(String _word, String _meaning) {
        this._word = _word;
        this._meaning = _meaning;
    }

    public String getWord() {
        return _word;
    }

    public void setWord(String _word) {
        this._word = _word;
    }

    public String getMeaning() {
        return _meaning;
    }

    public void setMeaning(String _meaning) {
        this._meaning = _meaning;
    }
    private String _word;
    private String _meaning;
}
