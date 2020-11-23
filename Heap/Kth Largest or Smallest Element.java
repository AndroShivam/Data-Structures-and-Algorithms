import java.util.Collections;
import java.util.PriorityQueue;

class LearningDS {
    public static void main(String[] args) {

        // minHeap for Kth largest element
        // maxHeap for Kth smallest element

        int[] nums = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;

        KthLargestElement(nums, k);
        KthSmallestElement(nums, k);
    }

    private static void KthSmallestElement(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        System.out.println("Kth Smallest Element : " + maxHeap.peek());
    }

    private static void KthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        System.out.println("Kth Largest Element : " + minHeap.peek());
    }
}
