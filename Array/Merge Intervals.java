// Time Complexity -> O(NlogN) + O(N) = O(NlogN)

class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length <= 1)
            return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // sort according to first element of array 
        
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        
        for(int[] interval : intervals){
            if(newInterval[1] >= interval[0]){
                newInterval[1] = Math.max(newInterval[1], interval[1]); // for [1,3] [2,6] Max(3,6) -> newInterval = [1,6] 
            }else{ // if two intervals does not match
                newInterval = interval;
                result.add(newInterval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Same Solution but cleaner and shorter


class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); // sort according to first index
        
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }else{ // if [1,3] [2,6] merged.getLast()[1] > interval[0]
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}