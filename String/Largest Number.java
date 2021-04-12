// Time Complexity - O(nkLogN) (where k is the avg length of string)
// Space Complexity - O(N)

class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        
        int n = nums.length;
        String[] sNums = new String[n];
        
        for(int i=0; i<n; i++)
            sNums[i] = String.valueOf(nums[i]);
        
        Arrays.sort(sNums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2)); 
        
        if(sNums[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s : sNums)
            sb.append(s);
        
        return sb.toString();
            
    }
}