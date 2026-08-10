class Solution {
    // Trie Node structure
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Holds full word at leaf node
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        // Traverse every cell in the board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        char ch = board[r][c];

        // Base cases: visited cell or character not in current Trie branch
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        // Found a word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicate additions
        }

        // Mark cell as visited
        board[r][c] = '#';

        // Explore all 4 directions
        int[] rowDirs = {-1, 1, 0, 0};
        int[] colDirs = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newR = r + rowDirs[i];
            int newC = c + colDirs[i];

            if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length) {
                dfs(board, newR, newC, node, result);
            }
        }

        // Backtrack: restore cell character
        board[r][c] = ch;
    }

    // Helper function to build the Trie
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char ch : w.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.word = w; // Store word at terminal node
        }
        return root;
    }
}