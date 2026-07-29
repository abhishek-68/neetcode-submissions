class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ansSet = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    if (sum == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        
                        ansSet.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(ansSet);
    }
}