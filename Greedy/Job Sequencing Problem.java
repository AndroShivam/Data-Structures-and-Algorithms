import java.util.ArrayList;
import java.util.Arrays;

class Job {
    char id;
    int deadline, profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class LearningDS {
    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>();

        jobs.add(new Job('a', 2, 100));
        jobs.add(new Job('b', 1, 19));
        jobs.add(new Job('c', 2, 27));
        jobs.add(new Job('d', 1, 25));
        jobs.add(new Job('e', 3, 15));

        jobSequencing(jobs, jobs.size());
    }

    private static void jobSequencing(ArrayList<Job> jobs, int n) {
        jobs.sort((a, b) -> b.profit - a.profit);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (jobs.get(i).deadline > max) {
                max = jobs.get(i).deadline;
            }
        }

        boolean[] hasSpace = new boolean[max + 1];
        char[] jobsID = new char[max + 1];
        int totalProfit = 0;

        Arrays.fill(hasSpace, true);

        for (int i = 0; i < n; i++) {
            for (int j = jobs.get(i).deadline; j > 0; j--) {
                if (hasSpace[j]) {
                    hasSpace[j] = false;
                    jobsID[j] = jobs.get(i).id;
                    totalProfit += jobs.get(i).profit;
                    break;
                }
            }
        }

        System.out.println("Total Profit : " + totalProfit);
        for (int i = 1; i < jobsID.length; i++) {
            System.out.println(jobsID[i]);
        }
    }
}