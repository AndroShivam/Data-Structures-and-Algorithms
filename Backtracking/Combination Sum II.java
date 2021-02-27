class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void backtrack(int index, int[] candidates, int target, List<Integer> tempList, List<List<Integer>> result){
        if(target < 0)
            return;
        else if(target == 0)
            result.add(new ArrayList<>(tempList));
        else{
            for(int i=index; i<candidates.length; i++){
                if(i > index && candidates[i] == candidates[i - 1]) continue; // skip duplicates
                tempList.add(candidates[i]);
                backtrack(i + 1, candidates, target - candidates[i], tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}