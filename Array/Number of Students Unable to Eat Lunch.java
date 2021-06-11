// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = {0, 0};
        
        for(int i=0; i<students.length; i++)
            count[students[i]]++;
        
        int k = 0;
        while(k < sandwiches.length){
            if(count[sandwiches[k]] > 0)
                count[sandwiches[k]]--;
            else
                break;
            
            k++;
        }
        
        return sandwiches.length - k;
    }
}