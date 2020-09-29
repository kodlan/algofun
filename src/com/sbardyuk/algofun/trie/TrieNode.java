package com.sbardyuk.algofun.trie;

import java.util.HashMap;

public class TrieNode {

    private HashMap<Character, TrieNode> children = new HashMap<>();

    private boolean isWordEnd;

    public TrieNode() {
    }

    public void markAsLeaf() {
        isWordEnd = true;
    }

    public void unmarkAsLeaf() {
        isWordEnd = false;
    }

    public boolean containsChar(char ch) {
        return children.containsKey(ch);
    }

    public TrieNode addChar(char ch) {
        TrieNode node = new TrieNode();
        children.put(ch, node);
        return node;
    }

    public TrieNode getTrieNode(char ch) {
        return children.get(ch);
    }

    public boolean isWordEnd() {
        return isWordEnd;
    }

    public boolean hasNoChildren() {
        return children.keySet().isEmpty();
    }

    public void clearChildren(char ch) {
        children.remove(ch);
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }
}
