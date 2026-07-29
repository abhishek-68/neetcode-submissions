class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int mostWater = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int water = Math.min(heights[i], heights[j]) * (j-i);
                mostWater = Math.max(mostWater, water);
            }
        }

        return mostWater;
    }
}
