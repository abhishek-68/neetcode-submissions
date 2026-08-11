class Solution {
    private int findDist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> findDist(a) - findDist(b));

        for (int[] p : points) {
            pq.offer(p);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}