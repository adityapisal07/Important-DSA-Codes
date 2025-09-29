import java.util.*;

public class maximumNonAdjacentSum{

       public static int solveMemo(int n,int[] nums,int[] dp){
              // no left case
              if(n < 0)
              return 0;
              //base case
              if(n == 0)
              return nums[0];
              //if dp array is not containing -1 return value in dp 
              if(dp[n] != -1)
              return dp[n];
              //include cases
              int incl = solveMemo(n-2,nums,dp) + nums[n];
              //exclude cases
              int excl = solveMemo(n-1,nums,dp) + 0;
              
              dp[n] = Math.max(incl,excl);

              return dp[n];
       }
         
       public static int maximumNonAdjacentSum(int[] nums) {

        int n = nums.length;
        //make dp array and intialize all the values to -1 
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);


        return solveMemo(n-1,nums,dp);
       }     
       public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 9};
        System.out.println("Maximum Non-Adjacent Sum = " + maximumNonAdjacentSum(nums));
       }
}