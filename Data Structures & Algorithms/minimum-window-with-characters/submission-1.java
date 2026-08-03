class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        int[] tCount = new int[128];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }

        int required = 0; // Number of unique characters in t that need to be satisfied
        for (int count : tCount) {
            if (count > 0) required++;
        }

        int[] windowCount = new int[128];
        int formed = 0; // Number of unique characters in current window meeting t's required frequency

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount[c]++;

            // If the current character's frequency matches its required count in t
            if (tCount[c] > 0 && windowCount[c] == tCount[c]) {
                formed++;
            }

            // Try to shrink the window from the left as long as it remains valid
            while (left <= right && formed == required) {
                // Update minimum length and starting index
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // Remove character at left pointer
                char leftChar = s.charAt(left);
                windowCount[leftChar]--;
                if (tCount[leftChar] > 0 && windowCount[leftChar] < tCount[leftChar]) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}