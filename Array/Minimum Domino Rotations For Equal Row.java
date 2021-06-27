// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops.length != bottoms.length) return -1;
        
        int[] countTops = new int[7];
        int[] countBottoms = new int[7];
        int[] same = new int[7];
        
        for(int i=0; i<tops.length; i++){
            countTops[tops[i]]++;
            countBottoms[bottoms[i]]++;
            if(tops[i] == bottoms[i])
                same[tops[i]]++;
        }
        
        for(int i=1; i<7; i++){
            if(countTops[i] + countBottoms[i] - same[i] >= tops.length)
                return Math.min(countTops[i], countBottoms[i]) - same[i];
        }
        
        return -1;
    }
}