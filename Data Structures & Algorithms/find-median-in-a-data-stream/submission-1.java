class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Stores lower half
    private PriorityQueue<Integer> minHeap; // Stores upper half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Add to maxHeap first, then route the largest value to minHeap
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        // Step 2: Keep maxHeap larger than or equal to minHeap in size
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}