// Convert to String change first 6 to 9 then convert back to Integer

class Solution {
    public int maximum69Number (int num) {
        
        char[] c = String.valueOf(num).toCharArray();        
        
        for(int i=0; i<c.length; i++){
            if(c[i] == '6'){
                c[i] = '9';
                break;
            }
        }
        
        return Integer.parseInt(new String(c));
    }
}

// Without Converting to String

class Solution {
    public int maximum69Number (int num) {
        
        int number = num;
        int firstSix = -1;
        
        for(int i=0; number > 0; i++){
            if(number % 10 == 6){
                firstSix = i;
            }
            number /= 10;
        }
        
        return num + 3 * (int)Math.pow(10, firstSix);
    }
}