class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = 0;
            int rightMax = 0;

            // Find maximum element to the left of index i
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find maximum element to the right of index i
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // Calculate trapped water at index i
            totalWater += Math.min(leftMax, rightMax) - height[i];
        }

        return totalWater;
    }
}