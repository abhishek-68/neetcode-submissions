class Solution {
    private int binarySearch(int st, int end, int[] arr, int x) {
        if(st > end) {
            return -1;
        }

        int mid = st + (end - st)/2;

        if(arr[mid] == x) {
            return mid;
        }

        if(arr[mid] > x) {
            return binarySearch(st, mid-1, arr, x);
        }
        return binarySearch(mid+1, end, arr, x);
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int st = 0;
        int end = n-1;
        
        return binarySearch(st, end, nums, target);
    }
}
