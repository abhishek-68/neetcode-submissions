class Solution {
    private int dfs(TreeNode root, int maxVal) {
        if(root == null) {
            return 0;
        }

        // check for current node
        int count = 0;
        if(root.val >= maxVal) {
            count = 1;
            maxVal = root.val; // Update max value along the current path
        }

        // Recursively count good nodes in left and right subtrees
        count += dfs(root.left, maxVal);
        count += dfs(root.right, maxVal);

        return count;        
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}
