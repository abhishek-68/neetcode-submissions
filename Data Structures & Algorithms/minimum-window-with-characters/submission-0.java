class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        String result = "";

        // Generate all substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (containsAll(sub, t)) {
                    if (sub.length() < minLen) {
                        minLen = sub.length();
                        result = sub;
                    }
                }
            }
        }
        return result;
    }

    // Helper method to check if 'sub' contains all characters of 't' with required counts
    private boolean containsAll(String sub, String t) {
        int[] tCount = new int[128];
        int[] subCount = new int[128];

        for (char c : t.toCharArray()) {
            tCount[c]++;
        }
        for (char c : sub.toCharArray()) {
            subCount[c]++;
        }

        for (int i = 0; i < 128; i++) {
            if (subCount[i] < tCount[i]) {
                return false;
            }
        }
        return true;
    }
}