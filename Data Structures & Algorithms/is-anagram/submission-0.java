class Solution {
    public boolean isAnagram(String s, String t) {
        char[] freq = new char[256];

        for(char c : s.toCharArray()) {
            freq[c]++;
        }
        for(char c : t.toCharArray()) {
            freq[c]--;
        }

        for(int i=0; i<256; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
