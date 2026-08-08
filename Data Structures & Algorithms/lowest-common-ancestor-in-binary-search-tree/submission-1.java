class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root.val < p.val && root.val < q.val) {
            // both are in right part
            return lowestCommonAncestor(root.right, p, q);
        }
        else if(root.val > p.val && root.val > q.val) {
            // both are in left part
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
            return root; // this is lca
        }
    }
}
