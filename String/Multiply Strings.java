class Solution {
    public String multiply(String num1, String num2) {
        
        int n1 = num1.length();
        int n2 = num2.length();
        
        int[] products = new int[n1 + n2];
        
        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                
                products[i + j + 1] += d1 * d2;
            }
        }
        
        int carry = 0;
        
        for(int i=products.length - 1; i>=0; i--){
            int temp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = temp;
        }
        
        StringBuilder res = new StringBuilder();
        for(int num : products)
            res.append(num);
        
        while(res.length() != 0 && res.charAt(0) == '0') // remove extra 0's
            res.deleteCharAt(0);
        
        return (res.length() == 0) ? "0" : res.toString();
    }
}