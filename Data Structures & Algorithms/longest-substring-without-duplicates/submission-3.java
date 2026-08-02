class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[256];

        int i = 0;
        int j = 0;

        int max_len = Integer.MIN_VALUE;

        while(j < n) {

            while(i < j && freq[s.charAt(j)] > 0) {
                freq[s.charAt(i)]--;
                i++;
            }

            freq[s.charAt(j)]++;
            
            int len = j-i+1;
            max_len = Math.max(len, max_len);

            j++;
        }

        return max_len == Integer.MIN_VALUE ? 0 : max_len;

    }
}
