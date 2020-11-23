import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class LearningDS {
    public static void main(String[] args) {

        // Given an array of n elements, where each element is at most k away from its target position,
        // devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2,
        // an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.

        int[] nums = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                list.add(minHeap.poll());
        }

        while (!minHeap.isEmpty())
            list.add(minHeap.poll());

        System.out.println(list);

        // Output
        // [2, 3, 5, 6, 8, 9, 10]

    }
}