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

        int st = 1;
        int end = max;

        while(st < end) {
            int mid = st + (end - st)/2;

            if(findHour(piles, mid, h)) {
                end = mid;
            }
            else {
                st = mid + 1;
            }
        }

        return st;
    }
}
