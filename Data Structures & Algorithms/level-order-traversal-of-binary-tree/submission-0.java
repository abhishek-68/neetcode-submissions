class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0; i<n; i++) {
                TreeNode top = queue.poll();

                temp.add(top.val);

                if(top.left != null) queue.add(top.left);
                if(top.right != null) queue.add(top.right);
            }

            ans.add(temp);
        }

        return ans;
    }
}
