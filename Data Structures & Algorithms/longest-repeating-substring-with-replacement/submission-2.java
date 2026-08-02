class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int hash[] = new int[26];

        for (int r = 0; r < s.length(); r++) {
            hash[s.charAt(r) - 'A']++;               // Add current character to window
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);   // Track max frequency

            // If replacements needed are more than k, shrink window
            if (r - l + 1 - maxFreq > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);    // Update max window size
        }
        return maxLen;
    }
}