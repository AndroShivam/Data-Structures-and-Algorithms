// Using Inbuilt Functions

public int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>(); // used to save simplified email address, cost O(n) sapce.
        for (String email : emails) {
            String[] parts = email.split("@"); // split into local and domain parts.
            String[] local = parts[0].split("\\+"); // split local by '+'.
            normalized.add(local[0].replace(".", "") + "@" + parts[1]); // remove all '.', and concatenate '@' and domain.        
        }
        return normalized.size();
    }
}

// Without using split, replace, indexOf

// Time Complexity - O(N*K) where K is the average length of the email
// Space Complexity - O(N)

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        
        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<email.length(); i++){
                if(email.charAt(i) == '.') continue;
                else if(email.charAt(i) == '+'){
                    int index = email.length() - 1;
                    while(email.charAt(index) != '@')
                        index--;
                    sb.append(email.substring(index)); // i.e @leetcode.com
                    break;
                }else if(email.charAt(i) == '@'){
                    sb.append(email.substring(i));
                    break;
                }else{ // alphabets
                    sb.append(email.charAt(i));
                }
            }
            set.add(sb.toString());
        }
        
        return set.size();
    }
}