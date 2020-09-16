package com.sbardyuk.algofun.trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }

        TrieNode currentNode = root;

        for (char ch : word.toLowerCase().toCharArray()) {
            if (!currentNode.containsChar(ch)) {
                currentNode.addChar(ch);
            }
            currentNode = currentNode.getTrieNode(ch);
        }
        currentNode.markAsLeaf();
    }

    public boolean search(String word) {
        TrieNode currentNode = root;

        for (char ch : word.toLowerCase().toCharArray()) {
            if (currentNode.containsChar(ch)) {
                currentNode = currentNode.getTrieNode(ch);
            } else {
                return false;
            }
        }

        return currentNode.isWordEnd();
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("test");
        trie.insert("testify");
        trie.insert("random");

        System.out.println(trie.search("test"));
        System.out.println(trie.search("testtest"));

    }

}
