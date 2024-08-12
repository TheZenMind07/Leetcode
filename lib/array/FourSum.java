import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
        public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i <= nums.length -4; i++) {
            for(int j = i+1; j <= nums.length -3; j++) {
                int updatedTarget = target - nums[i] - nums[j];
                int a = j+1, b = nums.length -1;
                while(a < b) {
                    if(updatedTarget == nums[a] + nums[b]){
                        res.add(Arrays.asList(nums[i], nums[j], nums[a], nums[b]));
                        a++; b--;
                    } else if(updatedTarget > nums[a] + nums[b]){
                        b--;
                    } else {
                        a++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(new FourSum().fourSum(nums, target));
        
    }
}
