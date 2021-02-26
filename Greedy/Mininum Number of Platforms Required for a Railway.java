// Time Complexity - O(N^2)
// Space Complexity - O(1)

class LearningDS {
    public static void main(String[] args) {

        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = 6;
        System.out.println(
                "Minimum Number of Platforms Required = "
                        + findPlatform(arr, dep, n));
    }

    private static int findPlatform(int[] arr, int[] dep, int n) {
        int platNeeded = 0, result = 0;
        for (int i = 0; i < n; i++) {
            platNeeded = 1;
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] >= arr[j] && arr[i] <= dep[j]) ||
                        (arr[j] >= arr[i] && arr[j] <= dep[i]))
                    platNeeded++;
            }
            result = Math.max(result, platNeeded);
        }

        return result;
    }
}

// Time Complexity - O(NLogN)
// Space Complexity - O(1)

class LearningDS {
    public static void main(String[] args) {

        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = 6;
        System.out.println(
                "Minimum Number of Platforms Required = "
                        + findPlatform(arr, dep, n));
    }

    private static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        // 900 940 950 1100 1500 1800
        // 910 1120 1130 1200 1900 2000

        int platNeeded = 1;
        int result = 1;
        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platNeeded++;
                i++;
            } else if (arr[i] > dep[j]) {
                platNeeded--;
                j++;
            }

            result = Math.max(platNeeded, result);
        }

        return result;
    }
}

//        arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
//        dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
//
//        All events are sorted by time.
//        Total platforms at any time can be obtained by
//        subtracting total departures from total arrivals
//        by that time.
//
//        Time      Event Type     Total Platforms Needed
//        at this Time
//        9:00       Arrival                  1
//        9:10       Departure                0
//        9:40       Arrival                  1
//        9:50       Arrival                  2
//        11:00      Arrival                  3
//        11:20      Departure                2
//        11:30      Departure                1
//        12:00      Departure                0
//        15:00      Arrival                  1
//        18:00      Arrival                  2
//        19:00      Departure                1
//        20:00      Departure                0
//
//        Minimum Platforms needed on railway station
//        = Maximum platforms needed at any time
//        = 3