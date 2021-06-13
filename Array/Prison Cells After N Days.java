// Time Complexity - O(1)
// Space Complexity - O(1)

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        if(cells == null || cells.length == 0 || n <= 0) return cells;
        
        Set<String> set = new HashSet<>();
        boolean hasCycle = false;
        int cycle = 0;
        
        for(int i=0; i<n; i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            
            if(!set.contains(key)){
                set.add(key);
                cycle++;
            }else{
                hasCycle = true;
                break;
            }
            cells = next;
        }
        
        if(hasCycle){
            n = n % cycle;
            for(int i=0; i<n; i++){
                cells = nextDay(cells);
            }
        }
        
        return cells;
    }
    
    private int[] nextDay(int[] cells){
        int[] temp = new int[cells.length];
        for(int i=1; i<cells.length - 1; i++){
            temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return temp;
    }
}