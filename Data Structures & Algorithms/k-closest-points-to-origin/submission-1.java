class Solution {

    private int findDist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> findDist(a) - findDist(b));

        return Arrays.copyOfRange(points, 0, k);
    }
}