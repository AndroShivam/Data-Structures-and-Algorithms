class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    
    private static void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int start){
        list.add(new ArrayList<>(templist));
        
        for(int i=start; i<nums.length; i++){
            templist.add(nums[i]);
            backtrack(list, templist, nums, i + 1);
            templist.remove(templist.size() - 1);
        }
    }
}

// Time Complexity: O(n * 2^n) 
// Space Complexity: O(n * 2^n)
/*
Explanation -

nums = [1,2,3]
powerset for nums = [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]] ( 2^N)

[] -> [1] -> [1,2] -> [1,2,3]
each time ask the question "Im at x can i add anything to it soo that its unique"
example - at [] we added 1 and its unique
          at [] -> [1] we added 2 to 1 and [1,2] is unique
          at [] -> [1] -> [1,2] we added 3 to [1,2] and [1,2,3] is unique
          at [1,2,3] we cannot add anything to make it unique
          so we move to second last branch i.e [1,2]
          we can't add anything to [1,2] to make it unique (i.e we already have [1,2,3])
          so we move one branch up again
          ask can we add anything to [1] to make it unique
          Yes, we can and that is 3 which makes [1,3]
          keeping doing that until we have all unique sets
*/