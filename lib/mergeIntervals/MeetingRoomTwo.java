import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoomTwo {
    public static void main(String[] args) {
        MeetingRoomTwo mrt = new MeetingRoomTwo();
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));
        System.out.println(mrt.minMeetingRooms(intervals));
    }
   public int minMeetingRooms(List<Interval> intervals) {
       int[] start = new int[intervals.size()];
       int[] end = new int[intervals.size()];

       int i = 0;
       for(Interval itr : intervals) {
           start[i] = itr.start;
           end[i] = itr.end;
       }
       Arrays.sort(start);
       Arrays.sort(end);
       int s = 0, e = 0, n = intervals.size();
       int res = 0;
       int temp = 0;
       while(s < n) {
           if(s <n && start[s] < end[e]) {
               s++;
               temp ++;
           } else {
               e++;
               temp--;
           }
           res = Math.max(res, temp);
       }
       return res;


       // Write your code here
   }
}
