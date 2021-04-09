class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        
        for(int i=0; i<columnTitle.length(); i++){
            result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }
}

// AA = 26 + 1 = 26 * 1 + 1
// BA = 26 + 26 + 1 = 26 * 2 + 1
// CA = 26 + 26 + 26 + 1 = 26 * 3 + 1