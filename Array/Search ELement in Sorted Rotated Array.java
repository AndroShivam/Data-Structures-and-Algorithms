import java.util.Scanner;

class LearningDS {
    public static void main(String[] args) {

        int[] a = {3, 4, 5, 1, 2};

        int index = searchInRotatedArray(a, 0, a.length - 1);
        System.out.println("Element found at : " + index);
    }

    private static int searchInRotatedArray(int[] a, int first, int last) {

        /*
         3  4  5  1  2
        */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to search : ");
        int target = scanner.nextInt();

        while (first <= last) {
            int mid = (first + last) / 2;

            if (a[mid] == target)
                return mid;

            else if (a[mid] >= a[first]) {
                // strictly increasing graph from first to mid

                if (target >= a[first] && target <= a[mid])
                    last = mid - 1;
                else
                    first = mid + 1;
            } else {

                // strictly increasing from mid to right

                if (target >= a[mid] && target <= a[last]) {
                    first = mid + 1;
                } else {
                    last = mid - 1;
                }
            }

        }

        return -1;

    }
}