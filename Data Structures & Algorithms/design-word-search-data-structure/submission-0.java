class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEoW = false;

    boolean contains(char ch) {
        return children[ch-'a'] != null;
    }

    void put(char ch, TrieNode node) {
        children[ch-'a'] = node;
    }

    TrieNode get(char ch) {
        return children[ch-'a'];
    }

    void setEnd() {
        isEoW = true;
    }

    boolean isEnd() {
        return isEoW;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(node.contains(ch) == false) {
                node.put(ch, new TrieNode());
            }

            node = node.get(ch);
        }

        node.setEnd();
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isEnd();
        }
        
        char ch = word.charAt(index);
        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!node.contains(ch)) {
                return false;
            }
            return dfs(word, index + 1, node.get(ch));
        }
    }
}











