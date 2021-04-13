// Time Complexity - O(N^2)
// Space Complexity - O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length - 1;
        int i = 0, profit = 0, buy, sell;
        
        while(i < N){
            while(i < N && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];
            
            while(i < N && prices[i + 1] > prices[i]) i++;
            sell = prices[i];
            
            profit += sell - buy;
        }
        
        return profit;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        
        return maxProfit;
    }
}