package com.sbardyuk.algofun.trie;

import java.util.Stack;

public class TrieCountWords extends Trie {

    public int countWords() {

        int count = 0;

        Stack<TrieNode> stack = new Stack<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {

            TrieNode node = stack.pop();
            if (!node.hasNoChildren()) {
                node.getChildren().values().forEach(stack::push);
            }

            if (node.isWordEnd()) {
                count ++;
            }

        }

        return count;
    }


    public static void main(String[] args) {
        TrieCountWords trie = new TrieCountWords();
        trie.insert("test");
        trie.insert("testify");
        trie.insert("random");

        int res = trie.countWords();
        System.out.println(res);
    }
}
