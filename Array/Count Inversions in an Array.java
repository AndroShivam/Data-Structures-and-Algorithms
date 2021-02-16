// Time Complexity - O(N^2)
// Space Complexity - O(1)

class LearningDS{
    public static void main(String[] args) {
        int[] nums = {8,6,4,2};
        int inversionCount = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] > nums[j]){
                    inversionCount++;
                }
            }
        }

        System.out.println(inversionCount);
    }
}