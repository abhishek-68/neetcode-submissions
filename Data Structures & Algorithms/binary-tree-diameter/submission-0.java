class Solution {
    int res = 0;

    private int solve(TreeNode root) {
        if (root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        res = Math.max(res, left + right);

        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return res;
    }
}