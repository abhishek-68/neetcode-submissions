class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean valid(TreeNode node, double left, double right) {
        if (node == null) {
            return true;
        }

        if (!(node.val > left && node.val < right)) {
            return false;
        }

        return valid(node.left, left, node.val) && valid(node.right, node.val, right);
    }
}