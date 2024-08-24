import java.util.ArrayDeque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k +1];
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        int i = 0;
        for(; i < nums.length; i++){
            insert(ad, nums, i);
            if(i-k +1 >= 0) {
                res[i-k+1] = nums[ad.peekFirst()];
            }
            if(ad.peekFirst() <= i - k) {
                ad.pollFirst();
            }
        }

        return res;
        
    }

    private void insert(ArrayDeque<Integer> ad, int[] nums, int index) {
        while( !ad.isEmpty() && nums[ad.peekLast()] < nums[index]) {
            ad.pollLast();
        }
        ad.addLast(index);
    }

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new MaxSlidingWindow().maxSlidingWindow(nums, k);
        System.out.println("Result : " + res);
    }
}
