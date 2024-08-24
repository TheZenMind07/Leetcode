import java.util.Stack;

public class LargestTriangle {
        public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int res = Integer.MIN_VALUE;
        int i = 0;

        while(i < heights.length) {
            if(st.isEmpty()){
                st.push(i++);
            } else {
                if(st.peek() > heights[i]) {
                    int curr = st.pop();
                    int left = st.isEmpty() ? -1 : st.peek();
                    res = Math.max(res, heights[curr]* (i - left -1));
                } else {
                    st.push(i++);
                }
            }
        }

        while(st.isEmpty() == false) {
            int curr = st.pop();
            int left = st.isEmpty() ? -1 : st.peek();
            res = Math.max(res, heights[curr]* (heights.length - left -1));
        }


        return res;
    }


    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,3};
        System.out.println("Result : " + new LargestTriangle().largestRectangleArea(heights));
    }
}
