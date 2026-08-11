class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max Heap

        for(int s : stones) {
            pq.offer(s);
        }

        while(pq.size() > 1) {
            int a = pq.poll();
            int b = 0;
            if(!pq.isEmpty()) {
                b = pq.poll();
            }

            if(a > b) {
                pq.offer(a-b);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
