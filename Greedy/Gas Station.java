class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        
        for(int i=0; i<gas.length; i++){
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        
        return (sumGas < sumCost) ? -1 : start;
    }
}