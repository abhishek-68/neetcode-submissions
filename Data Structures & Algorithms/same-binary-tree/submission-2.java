class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(p);
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.add(q);  

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node_p = queue1.poll();
            TreeNode node_q = queue2.poll();

            if (node_p == null && node_q == null) continue;
            if (node_p == null || node_q == null) return false;

            if (node_p.val != node_q.val) return false;

            queue1.add(node_p.left);
            queue2.add(node_q.left);

            queue1.add(node_p.right);
            queue2.add(node_q.right);
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}