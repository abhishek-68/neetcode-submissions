class Solution {
    private int maxPathSum;

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int belowRootAns = left + right + root.val; // (1)
        int leftOrRight = Math.max(left, right) + root.val; //(2) koiEkAcha 
        int onlyRoot = root.val; // (3)

        maxPathSum = Math.max(maxPathSum, 
                                Math.max(belowRootAns, 
                                Math.max(leftOrRight, onlyRoot)));  // max(1, 2, 3, maxPathSum)

        return Math.max(leftOrRight, onlyRoot);
    }

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        dfs(root);
        return maxPathSum;
    }
}
