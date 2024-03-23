package org.example.neetcode.tries;

public class ImplementTries {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.search("app");
        trie.startsWith("ap");
    }
}
class TrieNode {
    char value;
    boolean isWord;
    TrieNode[] child;
    TrieNode(char value) {
        this.value = value;
        this.isWord = false;
        this.child = new TrieNode[26];
    }
}

class Trie {
    TrieNode trie;
    public Trie() {
        trie = new TrieNode('0');
    }

    public void insert(String word) {
        insertWord(trie, word, 0);
    }

    private void insertWord(TrieNode root, String word, int index) {
        if(index == word.length()) {
            root.isWord = true;
            return;
        }

        int i = word.charAt(index) - 'a';
        if (root.child[i] == null) {
            root.child[i] = new TrieNode(word.charAt(index));
        }
        insertWord(root.child[i], word, index+1);
    }

    public boolean search(String word) {
        return search(trie, word, 0);
    }

    private boolean search(TrieNode root, String word, int index) {
        if (index == word.length())
            return root.isWord ? true : false;
        boolean result = false;
        int i = word.charAt(index) - 'a';
        if (root.child[i] != null && word.charAt(index) == root.child[i].value){
            result = search(root.child[i], word, index+1);
        }
        return result;
    }

    public boolean startsWith(String prefix) {
        return startsWith(trie, prefix, 0);
    }

    private boolean startsWith(TrieNode root, String word, int index) {
        if (index == word.length())
            return true;

        boolean result = false;
        int i = word.charAt(index) - 'a';
        if (root.child[i] != null && word.charAt(index) == root.child[i].value){
            result = startsWith(root.child[i], word, index+1);
        }
        return result;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */