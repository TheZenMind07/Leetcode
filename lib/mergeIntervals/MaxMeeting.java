import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxMeeting {
     class Interval implements Comparable<Interval>{
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Interval b) {
            if(this.start == b.start) {
                return this.end - b.end;
            }
            return this.start - b.start;
        }
    }
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        
        for(int i = 0; i <n ; i++){
            intervals.add(new Interval(start[i], end[i]));
        }
        
        Collections.sort(intervals);
        
        List<Interval> res = new ArrayList<Interval>();
        
        for(Interval itr : intervals) {
            if(res.size() == 0) res.add(itr);
            else {
                if(isOverlapping(res.get(res.size()-1), itr)) {
                    continue;
                } else {
                    res.add(itr);
                }
            }
        }
        
        return res.size();
    }
    
    
    public boolean isOverlapping(Interval a, Interval b) {
        return a.end >= b.start;
    }
}