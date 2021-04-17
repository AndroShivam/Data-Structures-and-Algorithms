// Time Complexity - O(N * K)
// Space Complexity - O(N)

class Solution {
    public int findTheWinner(int n, int k) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1; i<=n; i++)
            queue.offer(i);
        
        while(queue.size() != 1){
            int temp = k;
            while(temp > 1){
                int current = queue.poll();
                queue.offer(current);
                temp--;
            }
            queue.poll();
        }
        
        return queue.poll();
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int findTheWinner(int n, int k) {
        
        int result = 0;
        
        for(int i = 1; i <= n; i++)
            result = (result + k) % i;
        
        return result + 1;
    }
}