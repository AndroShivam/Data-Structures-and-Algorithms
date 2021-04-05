// Using Two Sets

// Time Complexity - O(N+M)
// Space Complexity - O(N+M)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int num : nums1)
            set1.add(num);
        
        for(int num : nums2)
            set2.add(num);
        
        if(set1.size() < set2.size())
            return setIntersection(set1, set2);
        else
            return setIntersection(set2, set1);
    }
    
    private int[] setIntersection(Set<Integer> set1, Set<Integer> set2){
        int[] result = new int[set1.size()];
        int index = 0;
        
        for(Integer num : set1){
            if(set2.contains(num))
                result[index++] = num;
        }
        
        return Arrays.copyOf(result, index);
    }
}

// Using Two Sets with inbuilt set intersection (retainAll)

// Time Complexity - O(N+M)
// Space Complexity - O(N+M)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int num : nums1)
            set1.add(num);
        
        for(int num : nums2)
            set2.add(num);
        
        set1.retainAll(set2);
        
        int[] result = new int[set1.size()];
        int index = 0;
        
        for(int num : set1)
            result[index++] = num;
        
        return result;
    }
}


// Using Sorting

// Time Complexity - O(NLogN)
// Space Complexity - O(N)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>();
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] > nums2[j])
                j++;
            else{
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] result = new int[set.size()];
        int index = 0;
        for(int num : set)
            result[index++] = num;
        
        return result;
    }
}

// Using Binary Search

// Time Complexity - O(NLogN)
// Space Complexity - O(N)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) // we will sort smaller array
            intersection(nums2, nums1);
        
        Set<Integer> set = new HashSet<>();
        
        Arrays.sort(nums1);
        
        for(int num : nums2){
            if(isPresent(nums1, num))
                set.add(num);
        }
        
        int[] result = new int[set.size()];
        int index = 0;
        for(int num : set){
            result[index++] = num;
        }
        
        return result;
    }
    
    private boolean isPresent(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target)
                return true;
            
            if(target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return false;
    }
}