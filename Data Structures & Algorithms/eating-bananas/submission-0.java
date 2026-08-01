class Solution {
    private boolean findHour(int[] piles, int k, int h) {
        int hour = 0;
        for(int pile : piles) {
            hour += Math.ceil((double)pile/k);
        }

        if(hour > h) {
            return false;
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        for(int pile : piles) {
            if(max < pile) {
                max = pile;
            }
        }

        // here k is eaiting rate of banana per hour
        for(int k=1; k<=max; k++) {
            if(findHour(piles, k, h)) {
                return k;
            }
        }

        return -1;
    }
}
