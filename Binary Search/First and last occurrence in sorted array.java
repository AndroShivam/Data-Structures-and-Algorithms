class LearningDS {
    public static void main(String[] args) {

        int[] a = {2, 4, 10, 10, 10,10, 18, 20};
        int target = 10;

        int firstOccurrence = count(a, target, 0);
        int lastOccurrence = count(a, target, 1);

        System.out.print(lastOccurrence - firstOccurrence + 1);
    }

    private static int count(int[] a, int target, int flag) {

        int start = 0;
        int end = a.length - 1;

        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (a[mid] == target) { // for flag == 0 firstOccurrence and for flag == 1 lastOccurrence
               if(flag == 0){
                   result = mid;
                   end = mid - 1;
               }else{
                   result = mid;
                   start = mid + 1;
               }
            } else if (target < a[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return result;
    }
}