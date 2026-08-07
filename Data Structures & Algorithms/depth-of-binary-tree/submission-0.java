class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);

        while(!queue.isEmpty()) {
            int n = queue.size();

            for(int i=0; i<n; i++) {
                TreeNode temp = queue.poll();
                
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }

            level++;
        }

        return level;
    }
}
