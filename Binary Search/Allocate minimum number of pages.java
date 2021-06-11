// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public static void main(String[] args) {
        int[] pages = {12, 34, 67, 90};
        int students = 2;

        int result = allocatePages(pages, students);
        System.out.println(result);
    }

    private static int allocatePages(int[] pages, int students) {
        int sum = 0, result = 0;

        for (int page : pages)
            sum += page;

        int low = 0, high = sum;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isPossible(pages, students, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] pages, int students, int barrier) {
        int studentsRequired = 1;
        int numOfPages = 0;

        for (int page : pages) {
            if (page > barrier) return false;
            if (numOfPages + page > barrier) {
                studentsRequired++;
                numOfPages = page;
                if (studentsRequired > students) return false;
            } else {
                numOfPages += page;
            }
        }
        return true;
    }
}