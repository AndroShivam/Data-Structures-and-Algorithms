import java.util.ArrayList;

class Meeting {
    int start;
    int end;
    int position;

    public Meeting(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
}

class LearningDS {

    private static void maxMeetings(ArrayList<Meeting> meetings, int n){
        ArrayList<Integer> result = new ArrayList<>();
        int timeLimit = 0;

        meetings.sort((a,b) -> a.end - b.end); // sort end in ascending order

        result.add(meetings.get(0).position); // add first meeting position
        timeLimit = meetings.get(0).end; // ending time of first meeting

        for(int i=0; i<n; i++){
            if(meetings.get(i).start > timeLimit){ // next meeting start is greater then this meeting end
                result.add(meetings.get(i).position);
                timeLimit = meetings.get(i).end;
            }
        }

        result.forEach(res -> System.out.print((res + 1) + " "));


    }
    public static void main(String[] args) {
        int s[] = {1, 3, 0, 5, 8, 5};
        int f[] = {2, 4, 6, 7, 9, 9};

        ArrayList<Meeting> meet = new ArrayList<>();

        for (int i = 0; i < s.length; i++)
            meet.add(new Meeting(s[i], f[i], i));

        maxMeetings(meet,meet.size());
    }
}