class Solution {
    public int totalFruit(int[] tree) {
        
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int max = 0;
        int currentMax = 0;
        
        for(int fruit : tree){
            if(fruit == lastFruit || fruit == secondLastFruit)
                currentMax++;
            else
                currentMax = lastFruitCount + 1;
            
            if(fruit == lastFruit)
                lastFruitCount++;
            else
                lastFruitCount = 1;
            
            if(fruit != lastFruit){
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }
            
            max = Math.max(max, currentMax);
        }
        
        return max;
    }
}