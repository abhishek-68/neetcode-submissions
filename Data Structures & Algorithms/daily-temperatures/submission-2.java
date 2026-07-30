class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i + 1; j < n; j++) {
                cnt++;
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = cnt; 
                    break;
                }
            }
        }
        return ans;
    }
}