// Time Complexity - O(N^2) // .contains() uses naive algo O(NM)
// Space Complexity - O(N) // space used to build A + A

class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}

// Time Complexity - O(N^2) 
// Space Complexity - O(1)

class Solution {
    public boolean rotateString(String A, String B) {
        if(A == null || B == null || A.length() != B.length()) return false;
        if(A.length() == 0) return true;
        
        for(int i=0; i<A.length(); i++){
            if(rotateString(A, B, i))
                return true;
        }
        
        return false;
    }
    
    private boolean rotateString(String A, String B, int rotation){
        for(int i=0;  i<A.length(); i++){
            if(A.charAt(i) != B.charAt((i + rotation) % B.length()))
                return false;
        }
        return true;
    }
}