// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int num : nums){
            if(map.get(num) > Math.floor(nums.length / 3.0)){
                set.add(num);
            }
        }
        
        return new ArrayList<>(set);
        
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        int num1 = -1;
        int num2 = -1;
        int count1 = 0;
        int count2 = 0;
        
        for(int num : nums){
            if(num == num1)
                count1++;
            else if(num == num2)
                count2++;
            else if(count1 == 0){
                num1 = num;
                count1++;
            }else if(count2 == 0){
                num2 = num;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int num : nums){
            if(num == num1)
                count1++;
            else if(num == num2 )
                count2++;
        }
        
        
        if(count1 > nums.length / 3)
            list.add(num1);
        if(count2 > nums.length / 3)
            list.add(num2);
        
        
        return list;
    }
}

/*

EXPLANATION :

credits to @ZhaoJing_0x & ZhaoJing_0x on leetcode

@liji94188 said in Boyer-Moore Majority Vote algorithm and my elaboration:

Great algorithm, but need some more explanation on the confusing word 2 "majorities". They are not necessarily be the 2 most frequent elements after the 1st round. Here is why the poster's 2 "majorities" algorithm really works:
consider 3 cases:

1. there are no elements that appears more than n/3 times, then whatever the algorithm 
 got from 1st round wound be rejected in the second round.
2. there are only one elements that appears more than n/3 times, after 1st round one of 
 the candicate must be that appears more than n/3 times(<2n/3 other elements could only
 pair out for <n/3 times), the other candicate is not necessarily be the second most frequent 
 but it would be rejected in 2nd round.
3. there are two elments appears more than n/3 times, candicates would contain both of
 them. (<n/3 other elements couldn't pair out any of the majorities.)
I will explain to people who don't understand his second claim, which took me a long time to understand. ;)

First, we claim: given n numbers and the k counters, only less than n/(k+1) times pair-out can happen.
That is to say:

given n numbers and 1 counter (which is the majority element problem), at most (n/2) times pair-out can happen, which will lead to the survival of the only element that appeared more than n/2 times.
given n numbers and 2 counters (which is our case), at most n/3 times of pair-out can happen, which will lead to the survival of elements that appeared more than n/3 times.
given n numbers and k counters, at most (n/k+1) times of pair-out can happen, which will lead to the survival of elements that appeared more than n/(k+1) times.
If this is the case, then n elements using two counters can at most pair out less than (n/3) times, which will result in the survival of the elements that appears more than (n/3) times.

First we look at an example of one counter:
suppose nums = [1, 2, 3, 4, 5, 6], and we are finding only one candidate and we have only one counter.

the procedure will be like this:

candidate = 1, counter = 1

current number = 2
candidate = 1, counter = 0
(one pair-out happens)

current number = 3
candidate = 3, counter = 1
(pair-out cannot happen now since there's nothing to pair out! Instead, counter got increased!)

current number = 4
candidate = 3, counter = 0
(one pair-out happens)

current number = 5
candidate = 5, counter = 1
(pair-out cannot happen and counter increased!)

curent number = 6
candidate = 5, counter = 0
(one pair-out happens)

From the above example, there are 6 elements in nums and we paired out 3 times, which is the most we can get. Suppose nums = [1,1,1,1,2,3], now we see that pair-out can happen only twice in this case.

From the above example, it's obvious that to pair out once, you have to increase the counter at least once.
And to pair out some candidate, you need first increase the counter. And every time you increase the counter, you waste one chance to pair out. So given n numbers, you can at most pair out (n/2) times, since you have to at least increase the counter (n/2) times to let you have something to pair out. It's quite like the amortized analysis, but if you don't know that, it doesn't matter though.

Now we still use the example above but we hope to find two candidates:
suppose nums = [1, 2, 3, 4, 5, 6], and we are finding two candidates and we have two counters.

the procedure will be like this:

candidate1 = 1, counter1 = 1
candidate2 = 2, counter2 = 1

current number = 3
candidate1 = 1, counter1 = 0
candidate2 = 2, counter2 = 0
(one pair-out happens and both counters got decreased.)

current number = 4
candidate1 = 4, counter = 1
candidate2 = 2, counter2 = 0
(pair-out cannot happen and counter1 got increased)

current number = 5
candidate1 = 4, counter1 = 1
candidate2 = 5, counter2 = 1
(pair-out can still not happen and counter2 got incresed)

current number = 6
candidate1 = 4, counter1 = 0
candidate2 = 5, counter2 = 0
(pair-out happens and both counters become 0)

Now we see, there are 6 elements in nums and we paired out 2 times, which is also the most we can get. Suppose nums = [1,1,1,1,2,3], pair-out can happen only once in this case.

This is because once pair-out happens, both counters decrease. And when some counter becomes 0, only one counter will get increased at a time. So to pair out m times, each counter have to be increased at least m times, which is to increase 2*m times totally.

It's not difficult to generalize to k counters. Of course, when k is large, it may be not efficient to use this count-and-pair-out method. However, the algorithm is still worth learning.

Hope it helps :)

*/

