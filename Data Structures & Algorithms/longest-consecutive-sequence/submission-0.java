class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num : nums) {
            st.add(num);
        }

        int ans = 0;

        for(int num : nums) {
            int streak = 0;
            int curr = num;

            while(st.contains(curr)) {
                streak++;
                curr++;
            }

            ans = Math.max(ans, streak);
        }

        return ans;
    }
}
