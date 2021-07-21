package Trie;

public class Solution {
    static class Trie{
        Trie[] next = new Trie[26];
        boolean isWord = false;
    }

    static Trie root;

    public void insert(String word){
        Trie itr = root;
        for (char c : word.toCharArray()){
            if(itr.next[c - 'a'] == null){
                itr.next[c - 'a'] = new Trie();
            }
            itr = itr.next[c - 'a'];
        }
        itr.isWord = true;
    }
}
