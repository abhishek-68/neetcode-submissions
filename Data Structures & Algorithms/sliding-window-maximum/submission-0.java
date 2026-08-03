class Solution {

    private int findMax(int[] arr, int i, int j) {
        int maxi = Integer.MIN_VALUE;
        for(int x=i; x<=j; x++) {
            maxi = Math.max(maxi, arr[x]);
        }
        return maxi == Integer.MIN_VALUE ? arr[0] : maxi;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = k - 1;
        ArrayList<Integer> ans = new ArrayList<>();


        while(j < nums.length) {
            ans.add(findMax(nums, i, j));
            i++;
            j++;
        }

        int[] result = new int[ans.size()];
        for(int x=0; x<ans.size(); x++) {
            result[x] = ans.get(x);
        }
        return result;
    }

}