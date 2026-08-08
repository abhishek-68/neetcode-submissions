class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null) {
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            int n = queue.size();

            for(int i=0; i<n; i++) {
                TreeNode temp = queue.poll();

                if(i == 0) {
                    ans.add(temp.val);
                }

                if(temp.right != null) queue.add(temp.right);
                if(temp.left != null) queue.add(temp.left);
            }
        }

        return ans;
    }
}
