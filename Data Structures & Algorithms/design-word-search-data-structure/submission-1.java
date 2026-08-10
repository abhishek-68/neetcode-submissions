class WordDictionary {

    private static class TrieNode {
        final TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private final TrieNode root = new TrieNode();

    public WordDictionary() {}

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.isEnd;

        char ch = word.charAt(index);
        if (ch != '.') {
            return dfs(word, index + 1, node.children[ch - 'a']);
        }

        // wildcard: try all non-null children
        for (TrieNode child : node.children) {
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        }
        return false;
    }
}