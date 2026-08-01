class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] nums = new int[m+n];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n && j < m) {
            if(nums1[i] <= nums2[j]) {
                nums[k++] = nums1[i++];
            }
            else {
                nums[k++] = nums2[j++];
            }
        }

        while(i<n) {
            nums[k++] = nums1[i++];
        }
        while(j<m) {
            nums[k++] = nums2[j++];
        }

        int len = nums.length;
        if(len % 2 == 0) {
            int mid = len / 2;
            return (nums[mid] + nums[mid-1]) / 2.0;
        } else {
            return nums[len/2];
        }
    }
}