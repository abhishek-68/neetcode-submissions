class Solution {
    private int idx = 0;
    private Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Pre-store all value -> index mappings for O(1) lookups
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] pre, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = pre[idx++];
        TreeNode root = new TreeNode(rootVal);
        
        // O(1) index retrieval instead of O(n) loop
        int mid = inMap.get(rootVal);

        // Build subtrees sequentially using preorder order
        root.left = dfs(pre, start, mid - 1);
        root.right = dfs(pre, mid + 1, end);

        return root;
    }
}