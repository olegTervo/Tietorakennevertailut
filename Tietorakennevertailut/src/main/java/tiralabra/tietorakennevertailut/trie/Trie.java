package tiralabra.tietorakennevertailut.trie;

import java.util.ArrayList;
import java.util.Set;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        /*
        insert("echo 'Hello!'");
        insert("test");
        insert("generate data");
        insert("generator");
        insert("end");
        insert("end");
        insert("ending");
        insert("e");
        insert("en");
        insert("ent");
        */
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, t -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    public boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }
    
    public ArrayList<String> getOptions(String word) {
        ArrayList<String> ret = new ArrayList();
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return new ArrayList();
            }
            if (node.isEndOfWord() && i == word.length()-1) {
                ret.add(word);
            }
            current = node;
        }
        
        ret.addAll(getOptions(word, current));
        
        return ret;
    }
    
    private ArrayList<String> getOptions(String word, TrieNode current) {
        ArrayList<String> ret = new ArrayList();
        Set<Character> chars = current.getChildren().keySet();
        
        for (Character ch : chars) {
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return new ArrayList();
            }
            if (node.isEndOfWord()) {
                ret.add(word + ch);
            }
            ret.addAll(getOptions(word + ch, node));
        }
        
        return ret;
    }

    public boolean isEmpty() {
        return root == null || root.getChildren().size() == 0;
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
    
    
}