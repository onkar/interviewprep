package main;

public class Trie {

  private static class TrieNode {
    char value;
    TrieNode[] children;
    int wordComplete;

    TrieNode() {
      this.value = '\0';
      this.children = new TrieNode[26];
      this.wordComplete = 0;
    }

  }

  private final TrieNode root;
  private int count;

  public Trie() {
    root = new TrieNode();
    count = 0;
  }

  public void insert(String key) {
    this.count++;
    TrieNode temp = root;
    for (int i = 0; i < key.length(); i++) {
      int index = key.charAt(i) - 'a';
      if (temp.children[index] == null) {
        temp.children[index] = new TrieNode();
        temp.children[index].value = key.charAt(i);
      }
      temp = temp.children[index];
    }
    temp.wordComplete = this.count;
  }

  public boolean search(String key) {
    TrieNode temp = root;
    for (int i = 0; i < key.length(); i++) {
      int index = key.charAt(i) - 'a';
      if (temp.children[index] == null) {
        return false;
      }
      temp = temp.children[index];
    }
    return (temp != null && temp.wordComplete != 0);
  }
}
