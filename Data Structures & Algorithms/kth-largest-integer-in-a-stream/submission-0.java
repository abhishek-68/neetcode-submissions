class KthLargest {

    PriorityQueue<Integer> pq; // Min heap
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;

        for(int n : nums) {
            pq.add(n);
            if(pq.size() > k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
