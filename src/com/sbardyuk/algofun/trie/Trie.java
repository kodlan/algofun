package com.sbardyuk.algofun.trie;

public class Trie {

    TrieNode root;

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

    public void delete(String word) {
        deleteRecursive(this.root, word, 0);
    }

    private boolean deleteRecursive(TrieNode currentNode, String word, int index) {

        if (currentNode == null) {
            return false;
        }

        if (index == word.length()) {
            // end reached

            if (!currentNode.isWordEnd()) {
                return false;
            }

            currentNode.unmarkAsLeaf();
            return currentNode.hasNoChildren();
        }

        boolean shouldDeleteChildren = deleteRecursive(currentNode.getTrieNode(word.charAt(index)), word, index + 1);

        if (shouldDeleteChildren && !currentNode.isWordEnd()) {
            currentNode.clearChildren(word.charAt(index));
        }

        return !currentNode.isWordEnd() && shouldDeleteChildren && currentNode.hasNoChildren();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("test");
        trie.insert("testify");
        trie.insert("random");

        System.out.println(trie.search("test"));
        System.out.println(trie.search("testtest"));

        trie.delete("testify");
        trie.delete("random");

        System.out.println();

    }

}
