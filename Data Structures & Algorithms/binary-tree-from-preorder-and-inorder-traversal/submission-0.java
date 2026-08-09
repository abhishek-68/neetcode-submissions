class Solution {
    private int idx = 0;

    private TreeNode dfs(int[] pre, int[] in, int start, int end) {
        if(start > end) {
            return null;
        }

        int rootVal = pre[idx++];
        TreeNode root = new TreeNode(rootVal);

        int i = 0;
        while(i < in.length) {
            if(rootVal == in[i]){
                break;
            }
            i++;
        }

        root.left = dfs(pre, in, start, i-1);
        root.right = dfs(pre, in, i+1, end);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return dfs(preorder, inorder, 0, n-1);
    }
}
