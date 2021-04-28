package tiralabra.tietorakennevertailut.trie;


import java.util.HashMap;
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