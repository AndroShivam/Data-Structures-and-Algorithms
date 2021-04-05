// Using HashMap

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int num : nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0); // if value becomes 0 then remove from map
            }
        }
        
        int[] result = new int[list.size()];
        int index = 0;
        
        for(int num : list)
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