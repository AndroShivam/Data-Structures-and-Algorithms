class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0] >= rec2[2] || rec2[0] >= rec1[2] || rec1[1] >= rec2[3] || rec2[1] >= rec1[3]);
    }
}

// Explanation (image)
// https://assets.leetcode.com/users/leetspeak/image_1589101811.png
// credits @stealthm on leetcode.com

// the above solution fails at one case
// so, this one works fine

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return max(rec1[0], rec2[0]) < min(rec1[2], rec2[2]) && max(rec1[1], rec2[1]) < min(rec1[3], rec2[3]);
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }
    private int min(int a, int b) {
        return Math.min(a, b);
    }
} 