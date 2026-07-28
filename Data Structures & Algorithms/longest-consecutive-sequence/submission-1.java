class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num : nums) {
            st.add(num);
        }

        int ans = 0;

        for(int num : nums) {
            if(!st.contains(num-1)) {
                int currentItem = num;
                int currentCount = 1;

                while(st.contains(currentItem+1)) {
                    currentItem += 1;
                    currentCount++;
                }

                ans = Math.max(ans, currentCount);
            }
        }

        return ans;
    }
}
