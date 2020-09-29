package com.sbardyuk.algofun.trie;

import java.util.stream.Stream;

public class TrieIsFormattingPossible extends Trie {

    boolean isFormattingPossibleInternal(TrieNode currentNode, String word, int index) {

        if (currentNode == null) {
            return false;
        }

        if (index == word.length() - 1 && currentNode.containsChar(word.charAt(index)) && currentNode.isWordEnd()) {
            return true;
        } else if (index == word.length() - 1) {
            return false;
        }

        if (currentNode.isWordEnd() && isFormattingPossibleInternal(root, word, index + 1)) {
            return true;
        }

        currentNode = currentNode.getTrieNode(word.charAt(index));
        return isFormattingPossibleInternal(currentNode, word, index + 1);
    }



    static boolean isFormationPossible(String[] dict, String word) {

        TrieIsFormattingPossible trie = new TrieIsFormattingPossible();

        Stream.of(dict).forEach(trie::insert);

        return trie.isFormattingPossibleInternal(trie.root, word, 0);
    }

    public static void main(String[] args) {

        String[] dict = {"the" ,"hello", "there", "answer", "any", "Dragon",
                "world", "their", "inc"};

        String word = "helloworld";

        System.out.println(isFormationPossible(dict, word));


    }
}
