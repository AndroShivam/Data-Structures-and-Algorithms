class Solution {
    public int largestRectangleArea(int[] heights) {
        
        if(heights == null || heights.length == 0)
            return 0;
        
        int n = heights.length;
        
        int[] nextSmallerToTheRight = new int[n];
        int[] nextSmallerToTheLeft = new int[n];
        
        nextSmallerToTheRight[n - 1] = n; // set the right boundary to n (assuming they're all small)
        nextSmallerToTheLeft[0] = -1; // set the left boundary to -1 (assuming they're all small)
        
        for(int i=1; i<n; i++){
            int p = i - 1;
            
            while(p >= 0 && heights[p] >= heights[i])
                p = nextSmallerToTheLeft[p];
            
            nextSmallerToTheLeft[i] = p;
        }
        
        for(int i= n-2; i>=0; i--){
            int p = i + 1;
            
            while(p < n && heights[p] >= heights[i])
                p = nextSmallerToTheRight[p];
            
            nextSmallerToTheRight[i] = p;
        }
        
        int maxArea = 0;
        
        for(int i=0; i<n; i++){
            int width = nextSmallerToTheRight[i] - nextSmallerToTheLeft[i] - 1;
            int currentMax = heights[i] * width;
            if(currentMax > maxArea)
                maxArea = currentMax;
        }
        
        return maxArea;
    }
	
	/*
	This is a Stack Problem, You can calculate nextSmallerToTheLeft and nextSmallerToTheRight using this method too but this requires extra memory
	  private static List<Integer> nextSmallerToTheLeft(int[] hist, int n) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();


        stack.push(0);
        list.add(-1);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && hist[i] < hist[stack.peek()])
                stack.pop();

            if (stack.isEmpty()) list.add(-1);
            else list.add(stack.peek());

            stack.push(i);
        }

        return list;
    }

    private static List<Integer> NextSmallerToTheRight(int[] hist, int n) {
        // 6 2 5 4 5 1 6
        // 1 5 3 5 5 7 7

        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int[] res = new int[n];
        // push last index
        stack.push(n - 1);
        res[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && hist[i] < hist[stack.peek()])
                stack.pop();
            if (stack.isEmpty()) res[i] = n;
            else res[i] = stack.peek();
            stack.push(i);
        }
        for (int re : res) list.add(re);

        return list;
	*/
}