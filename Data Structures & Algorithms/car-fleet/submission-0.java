public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        // sort indices by position descending
        Arrays.sort(idx, (a, b) -> position[b] - position[a]);

        int fleets = 0;
        double currentFleetTime = 0;

        for (int i : idx) {
            double time = (double)(target - position[i]) / speed[i];
            if (time > currentFleetTime) {
                fleets++;
                currentFleetTime = time;
            }
            // else: merges into current fleet, no update needed
        }
        return fleets;
    }
}