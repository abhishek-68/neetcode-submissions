class Solution {
    List<List<Integer>> ans;

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }

    private void backtrack(int[] arr, int index) {
        if(index == arr.length) {
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<arr.length; i++) {
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index; i<arr.length; i++) {
            swap(i, index, arr);
            backtrack(arr, index+1);
            swap(i, index, arr);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        backtrack(nums, 0);
        return ans;
    }
}
