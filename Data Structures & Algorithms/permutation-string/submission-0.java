class Solution {
    private boolean check(int[] arr1, int[] arr2) {
        for(int i=0; i<26; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        int windowSize = s1.length();

        int[] freq = new int[26];
        for(int i=0; i<windowSize; i++) {
            freq[s1.charAt(i)-'a']++;
        }

        int i = 0;
        int j = 0;
        int[] windowFreq = new int[26];

        while(j <s2.length()) {

            while((j-i+1) > windowSize) {
                windowFreq[s2.charAt(i)-'a']--;
                i++;
            }

            windowFreq[s2.charAt(j)-'a']++;

            if(check(freq, windowFreq)) {
                return true;
            }

            j++;
        }

        return false;
    }
}
