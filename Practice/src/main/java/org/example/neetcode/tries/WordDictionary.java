package org.example.neetcode.tries;

public class WordDictionary {
    Words words;
    public WordDictionary() {
        words = new Words('0');
    }

    public void addWord(String word) {
        addWord(words, word, 0);
    }

    private void addWord(Words words, String word, int index) {
        if (index == word.length()) {
            words.isWord = true;
            return;
        }

        int i = word.charAt(index) - 'a';
        if (words.child[i] == null) {
            words.child[i] = new Words(word.charAt(index));
        }
        addWord(words.child[i], word, index+1);
    }

    public boolean search(String word) {
        return search(words, word, 0);
    }

    private boolean search(Words words, String word, int index) {
        if (index == word.length()) {
            return words.isWord ? true : false;
        }
        boolean flag = false;
        if (word.charAt(index) == '.') {
            for (Words w : words.child) {
                if (w != null && search(w, word, index+1)) {
                    flag = true;
                    break;
                }
            }
        } else {
            int i = word.charAt(index) - 'a';
            if (words.child[i] != null && words.child[i].ch == word.charAt(index)) {
                flag = search(words.child[i], word, index+1);
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("at");
        dict.addWord("and");
        dict.addWord("an");
        dict.addWord("add");
//        System.out.println(dict.search("a"));
//        System.out.println(dict.search(".at"));
        dict.addWord("bat");
//        System.out.println(dict.search("an."));
//        System.out.println(dict.search(".at"));
//        System.out.println(dict.search("a.d."));
//        System.out.println(dict.search("b."));
        System.out.println(dict.search("a.d"));
//        System.out.println(dict.search("."));

    }
}

class Words {
    char ch;
    boolean isWord;
    Words[] child;
    public Words(char ch){
        this.ch = ch;
        isWord = false;
        child = new Words[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
