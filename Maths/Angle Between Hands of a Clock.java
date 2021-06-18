// Time Complexity - O(1)
// Space Complexity - O(1)

class Solution {
    public double angleClock(int hour, int minutes) {
        double min = minutes * 6;
        double hr = hour * 30 + (double)minutes/2;
        double angle = Math.abs(hr - min);
        return Math.min(angle, 360 - angle);
    }
}


/*
Hour Hand - 

- hour hand completes one rotation - 360
- how many hours are in the clock - 12 (1,2,3..12)

- for each hour - 360/12 = 30, hour hand moves 30 deg

- how many minutes are in the clock - 60
- in one hour - 30 / 60 , hour hand moves .5 degree

Minute Hand - 

- for each hour - 360/60 = 6, minute hand moves 6 deg

hence, for x hours and y minutes

hour hand - x * 30 + .5 * y
mint hand - y * 6
*/