class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void solve(int[] nums, int i, int target, List<Integer> set) {
        if(target == 0) {
            ans.add(new ArrayList<>(set));
            return;
        }

        if(target < 0 || i >= nums.length) return;

        // pic with same index
        set.add(nums[i]);
        solve(nums, i, target- nums[i], set);

        // not pic and move to next index
        set.remove(set.size()-1);
        solve(nums, i+1, target, set);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        solve(nums, 0, target, new ArrayList<>());
        return ans;
    }
}
