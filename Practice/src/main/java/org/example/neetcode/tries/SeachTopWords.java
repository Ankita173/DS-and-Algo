package org.example.neetcode.tries;

import java.util.ArrayList;
import java.util.List;

public class SeachTopWords {
    public static List<List<String>> getProductSuggestions(List<String> products, String search) {
        Dictionary dict = new Dictionary();
        dict.build(products);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < search.length(); i++) {
            List<String> match = dict.findMatches(search.substring(0, i+1), 5);
            if (match.size() == 0)
                return result;
            result.add(match);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> products = new ArrayList<>();
        products.add("camera");
        products.add("canera");
        products.add("care");
        products.add("core");
        products.add("came");
        System.out.println(getProductSuggestions(products, "camera"));
    }
}


class Dictionary {
    Dictionary[] letter;
    char value;
    boolean isWord;

    public Dictionary() {
        value = '0';
        letter = new Dictionary[26];
        isWord = false;
    }

    public Dictionary(char c) {
        value = c;
        letter = new Dictionary[26];
        isWord = false;
    }

    public void build(List<String> words) {
        for (String word : words) {
            insertWord(this, word, 0);
        }
    }

    private void insertWord(Dictionary root, String word, int index) {
        if (index == word.length()) {
            root.isWord = true;
            return;
        }
        int i = word.charAt(index) - 'a';
        if (root.letter[i] == null) {
            root.letter[i] = new Dictionary(word.charAt(index));
        }

        insertWord(root.letter[i], word, index+1);
    }

    public List<String> findMatches(String search, int count) {
        List<String> match = new ArrayList<>();
        findTopMatch(this, search, 0, new StringBuffer(), match, count);
        return match;
    }

    private void findTopMatch(Dictionary root,
                              String search,
                              int index,
                              StringBuffer word,
                              List<String> matches,
                              int count) {
        if (matches.size() == count) {
            return;
        }
        if (root.isWord && word.length() >= search.length()) {
            matches.add(word.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (root.letter[i] != null) {
                if (search.length() > index && root.letter[i].value == search.charAt(index)) {
                    findTopMatch(root.letter[i],
                            search,
                            index+1,
                            word.append(root.letter[i].value),
                            matches,
                            count);
                    word.deleteCharAt(word.length() - 1);
                } else if(search.length() <= index) {
                    findTopMatch(root.letter[i],
                            search,
                            index + 1,
                            word.append(root.letter[i].value),
                            matches,
                            count);
                    word.deleteCharAt(word.length() - 1);
                }
            }

        }

    }
}
