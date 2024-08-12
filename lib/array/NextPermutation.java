/**
 * NextPermutation
 */
public class NextPermutation {

    public static void main(String[] args) {

        int[] nums = {1,2,3};

        new NextPermutation().nextPermutation(nums);

        System.out.println(nums);
    }

    public void nextPermutation(int[] nums) {
        int br = -1;

        for(int i = nums.length - 2; i>= 0 ; i --) {
            if(nums[i] < nums[i+1]) {
                br = i;
            }
        }

        if(br == -1) {
            reverse(nums, 0 , nums.length -1 );
        } else {
            int ex = br +1,  iter = br +1;
            for(; iter < nums.length ; iter++) {
                if(nums[iter] > nums[br] && nums[iter] < nums[ex]) {
                    ex = iter;
                }
            }

            swap(nums, ex, br);
            reverse(nums, br +1, nums.length -1);
        }
        

        

    }

    public void reverse(int[] nums, int s, int e) {
        while(e >= s) {
            swap(nums, e--, s++);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}