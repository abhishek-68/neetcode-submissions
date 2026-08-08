/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private void preorder(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }

        arr.add(node.val);
        preorder(node.left, arr);
        preorder(node.right, arr);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();

        preorder(root, arr);
        Collections.sort(arr);
        return arr.get(k - 1);
    }
}
