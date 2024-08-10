import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;

    public MedianFinder() {
        minPq = new PriorityQueue<Integer>();
        maxPq = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxPq.isEmpty()) {
          maxPq.add(num);
          return;  
        } 

        if(num > maxPq.peek()) {
            minPq.add(num);
        } else {
            maxPq.add(num);
        }

        while(minPq.size() > maxPq.size()) {
            maxPq.add(minPq.poll());
        }

        while(maxPq.size() > minPq.size() + 1) {
            minPq.add(maxPq.poll());
        }

        System.out.println("Max pq :" + maxPq);
        System.out.println("Min pq :" + minPq);
    }
    
    public double findMedian() {
        if(maxPq.size() > minPq.size()) {
            return (double) maxPq.peek();
        } else {
            return ((double)maxPq.poll() + (double)minPq.poll() )/2.0;
        }
    }
    public static void main(String[] args) {
        System.out.println("This is runing");
        MedianFinder mdf = new MedianFinder();
        mdf.addNum(1);
        mdf.addNum(2);
        System.out.println(mdf.findMedian());
        mdf.addNum(3);
        System.out.println(mdf.findMedian());
    }
}
