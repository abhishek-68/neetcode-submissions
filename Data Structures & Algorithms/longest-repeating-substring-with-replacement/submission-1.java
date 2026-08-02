class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            int[] freq = new int[26];
            int maxFreq = 0;

            for (int j = i; j < s.length(); j++) {

                int index = s.charAt(j) - 'A';
                freq[index]++;

                maxFreq = Math.max(maxFreq, freq[index]);

                int len = j - i + 1;
                int change = len - maxFreq;

                if (change <= k) {
                    maxLen = Math.max(maxLen, len);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }
}