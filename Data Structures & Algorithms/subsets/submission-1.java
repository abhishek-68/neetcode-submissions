class Solution {
    private List<List<Integer>> result;

    private void dfs(int[] nums, int i, List<Integer> subSet) {
        if(i >= nums.length) {
            result.add(new ArrayList<>(subSet));
            return;
        }

        // include
        subSet.add(nums[i]);
        dfs(nums, i+1, subSet);

        //exclude
        subSet.remove(subSet.size()-1);
        dfs(nums, i+1, subSet);
    }

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        List<Integer> subSet = new ArrayList();

        dfs(nums, 0, subSet);
        return result;
    }
}
