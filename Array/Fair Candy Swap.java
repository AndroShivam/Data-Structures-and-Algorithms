class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        int sa = 0, sb = 0;
        
        for(int num : A) 
            sa += num;
        
        for(int num : B) 
            sb += num;
        
        int delta = (sb - sa)/2;
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : B) 
            set.add(num);
        
        for(int num : A){
            if(set.contains(num + delta))
                return new int[]{num, num + delta};
        }
        
        return null;
    }
}

// if alice swaps candy x and gets y candy back
// bob receives x and gives y
// if Sa = sum of alice candies
// if Sb = sum of bob candies
// hence, Sa - x + y = Sb - y + x

// y = x + (sb - sa)/2

// Our strategy is simple. For every candy x that Alice has, if Bob has candy y = x + (sb - sa)/2 