package Arrays;
import java.util.Arrays;
public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        //base case for no element in array
        if (n == 0)
            return 0;
        //base case for 1 element in array
        if (n == 1) {
            return nums[0];
        }
        //element in the middle
        for (int i = 0; i < n; i = i + 3) {
            if (i + 1 >= n || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        //if number is present at last
        return nums[n - 1];
    }

    public static void main(String[] args) {
        SingleNumber2 finder = new SingleNumber2();

        // Example test case
        int[] nums = {2, 2, 3, 2};
        System.out.println("Single Number is: " + finder.singleNumber(nums));

        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("Single Number is: " + finder.singleNumber(nums2));

        int[] nums3 = {5};
        System.out.println("Single Number is: " + finder.singleNumber(nums3));
    }
}
