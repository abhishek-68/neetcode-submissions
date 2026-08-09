class Solution {
    private int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        // 1. Path split taking both left and right branches through this root
        int belowRootAns = left + right + root.val;

        // 2. Continuous branch path picking the better child branch
        int leftOrRight = Math.max(left, right) + root.val;

        // 3. Path starting and ending exclusively at this root node
        int onlyRoot = root.val;

        // Update the global maximum considering all valid paths at this node
        int localMax = Math.max(belowRootAns, Math.max(leftOrRight, onlyRoot));
        maxPathSum = Math.max(maxPathSum, localMax);

        // Return the best single path that can extend up to the parent node
        return Math.max(leftOrRight, onlyRoot);
    }
}