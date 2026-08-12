class Solution {
    private List<List<Integer>> result;

    private void dfs(int[] nums, int i, List<Integer> subSet) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subSet));
            return;
        }

        // Include nums[i]
        subSet.add(nums[i]);
        dfs(nums, i + 1, subSet);
        subSet.remove(subSet.size() - 1);

        // Exclude nums[i] and skip all identical elements
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        
        dfs(nums, i + 1, subSet);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        // 1. Sort the array so duplicates are adjacent
        Arrays.sort(nums);
        
        // 2. Backtrack
        dfs(nums, 0, new ArrayList<>());
        return result;
    }
}