class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums){
        if(templist.size() == nums.length){
            list.add(new ArrayList<>(templist)); // If you directly add tempList, Java will add a reference to it, which will get meddled with as the recursion goes on, hurting what was originally put in 'list'. Hence it makes a copy of tempList to preserve its state.
        }else{
            for(int i=0; i<nums.length; i++){
                if(templist.contains(nums[i])) continue;
                templist.add(nums[i]);
                backtrack(list, templist, nums);
                templist.remove(templist.size() - 1);
            }
        }
    }
}

/*
Explanation -

Credits - Time Complexity Infinity (Youtube Channel)
Recursion Tree - https://drive.google.com/file/d/1_5t5nhX6N_23qcA_9i9WQXfNvPACe1mG/view?usp=sharing
Youtube Video Link - https://www.youtube.com/watch?v=KukNnoN-SoY
*/