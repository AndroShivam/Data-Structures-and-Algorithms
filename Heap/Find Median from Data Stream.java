// Using Sorting

// Time Complexity - O(NLogN)

class MedianFinder {

    ArrayList<Integer> list;
    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        
        int n = list.size();
        
        if(n % 2 == 0){
            return (double)(list.get((n - 1)/2) + list.get(n/2))/2.0;
        }else{
            return (double)(list.get((n)/2));
        }
    }
}

// Using Two Heaps

// Time Complexity - O(LogN) At worst, there are three heap insertions and two heap deletions from the top. Each of these takes about O(logn) time.

class MedianFinder {
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek())/2.0;
        else
            return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */