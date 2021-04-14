/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tietorakennevertailut.trie;


import java.util.HashMap;
/**
 *
 * @author oleg
 */
public class TrieNode {
    private HashMap<Character, TrieNode> map = new HashMap<>();
    private boolean endOfWord;

    HashMap<Character, TrieNode> getChildren() {
        return map;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}