class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    private void findCombination(int idx, int[] nums, int target, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=idx; i<nums.length; i++) {
            if(i > idx && nums[i] == nums[i-1]) continue;

            if(nums[i] > target) break;

            ds.add(nums[i]);
            findCombination(i+1, nums, target-nums[i], ds);
            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombination(0, candidates, target, new ArrayList<>());
        return ans;
    }
}
