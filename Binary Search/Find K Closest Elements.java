// Time Complexity - O(NLogN)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> list = new ArrayList<>();
        for(int num : arr) 
            list.add(num);
        
        Collections.sort(list, (a,b) -> a == b ? a - b : Math.abs(x - a) - Math.abs(x - b));
        list = list.subList(0, k);
        Collections.sort(list);
        
        return list;
    }
}

// Time Complexity - O(NLogK)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a,b) -> Math.abs(x - b) == Math.abs(x - a) ? b - a
            : Math.abs(x - b) - Math.abs(x - a)
        );
        
        for(int num : arr){
            maxHeap.offer(num);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        
        List<Integer> list = new ArrayList<>(maxHeap);
        Collections.sort(list);
        
        return list;
    }
}

// Time Complexity - O(N)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int left = 0;
        int right = arr.length - 1;
        
        while(right - left >= k){
            if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x))
                left++;
            else
                right--;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=left; i<=right; i++){
            list.add(arr[i]);
        }
        
        return list;
    }
}