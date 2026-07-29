class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int mostWater = 0;

        int left = 0;
        int right = n-1;

        while(left < right) {
            int water = Math.min(heights[left], heights[right]) * (right-left);
            mostWater = Math.max(mostWater, water);

            if(heights[left] < heights[right]) {
                left++;
            }
            else right--;
        }

        return mostWater;
    }
}
