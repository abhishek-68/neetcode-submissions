class Solution {
    List<List<Integer>> ans;

    private void backtrack(int[] arr, List<Integer> ds, boolean[] freq) {
        if(ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(!freq[i]) {
                freq[i] = true;
                ds.add(arr[i]);
                backtrack(arr, ds, freq);

                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), freq);
        return ans;
    }
}
