// Time Complexity - O(N*K)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        for(int i=0; i<=n-k; i++){
            int max = nums[i];
            for(int j=i; j<k+i; j++){
                if(nums[j] > max)
                    max = nums[j];
            }
            res[i] = max;
        }
        
        return res;
    }
}

// Time Complexity - O(N * LogK)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[nums.length - k + 1];
        
        int i=0, index = 0;
        for(; i<k; i++)
            maxHeap.offer(nums[i]);
        
        res[index++] = maxHeap.peek();
        
        maxHeap.remove(nums[0]);
        
        for(; i<nums.length; i++){
            maxHeap.add(nums[i]);
            
            res[index++] = maxHeap.peek();
            
            maxHeap.remove(nums[i - k + 1]); // remove first element from current window
        }
        
        return res;
        
    }
}

// Time Complexity - O(N)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return nums;
        
        int[] res = new int[n - k + 1];
        
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peek() < i - k + 1) // remove numbers out of range k
                dq.poll();
            
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) // remove smaller numbers in k range as they are useless
                dq.pollLast();
            
            dq.offer(i);
            
            if(i - k + 1 >= 0) // at the end of window add max to res
                res[i - k + 1] = nums[dq.peek()];
        }
        
        return res;
    }
}