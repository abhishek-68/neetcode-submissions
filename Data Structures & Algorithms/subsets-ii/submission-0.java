class Solution {
    private Set<List<Integer>> result;

    private void dfs(int[] nums, int i, List<Integer> subSet) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subSet));
            return;
        }

        // Include nums[i]
        subSet.add(nums[i]);
        dfs(nums, i + 1, subSet);

        // Exclude nums[i]
        subSet.remove(subSet.size() - 1);
        dfs(nums, i + 1, subSet);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new HashSet<>();
        
        // Sorting ensures elements inside each subset follow the same order 
        // e.g., both [1, 2] and [2, 1] become [1, 2], so the Set can filter duplicates.
        Arrays.sort(nums);

        dfs(nums, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }
}