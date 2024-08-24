import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // find all next greater element in nums2 by using a stack and store values in hashmap
        // iterate through and store values

        Stack<Integer> st = new Stack<Integer>();
        HashMap<Integer, Integer> hmap = new HashMap<>(); 
        for(int j = nums2.length -1 ; j >= 0 ;){
            if(st.isEmpty()){
                hmap.put(nums2[j], -1);
                j--;
            } else {
                if(!st.isEmpty() && st.peek() <= nums2[j]) {
                    st.pop();
                } else {
                    hmap.put(nums2[j], st.peek());
                    st.push(nums2[j]);
                    j--;
                }
            }
        }

        int[] res = new int[nums1.length];

        for(int i = 0; i < nums1.length; i ++) {
            res[i] = hmap.containsKey(nums1[i]) ? hmap.get(nums1[i]) :-1;
        }


        return res;
    }


    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res = new NextGreaterElement().nextGreaterElement(nums1, nums2);
        System.out.println("Result : " + res);
    }
}
