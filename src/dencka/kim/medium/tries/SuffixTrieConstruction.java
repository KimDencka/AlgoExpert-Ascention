package dencka.kim.medium.tries;

import java.util.*;

class SuffixTrieConstruction {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        // time - O(n^2), space - O(n^2)
        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                TrieNode cur = root;
                String word = str.substring(i);
                for (Character ch : word.toCharArray()) {
                    if (!cur.children.containsKey(ch)) {
                        cur.children.put(ch, new TrieNode());
                    }
                    cur = cur.children.get(ch);
                }
                cur.children.put(endSymbol, null);
            }
        }

        // time - O(m), space - O(1)
        public boolean contains(String str) {
            TrieNode trie = root;
            for (Character ch : str.toCharArray()) {
                if (!trie.children.containsKey(ch)) return false;
                trie = trie.children.get(ch);
            }
            return trie.children.containsKey(endSymbol);
        }
    }
}
