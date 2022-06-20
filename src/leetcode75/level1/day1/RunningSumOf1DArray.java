package leetcode75.level1.day1;

public class RunningSumOf1DArray {
    /*Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

    Return the running sum of nums.



    Example 1:

    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

    Example 2:

    Input: nums = [1,1,1,1,1]
    Output: [1,2,3,4,5]
    Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

    Example 3:

    Input: nums = [3,1,2,10,1]
    Output: [3,4,6,16,17]



    Constraints:

        1 <= nums.length <= 1000
        -10^6 <= nums[i] <= 10^6*/

    public static void main(String[] args) {

        RunningSumOf1DArray obj = new RunningSumOf1DArray();
        int[] output = obj.runningSum(new int[]{1,2,3,4});
        for(int i=0;i<output.length;i++) {
            System.out.println(output[i]);
        }

    }


    public int[] runningSum(int[] nums) {
        int[] output = new int[nums.length];
        if(nums.length >=1 && nums.length <= 1000) {
            output[0] = nums[0];
            for(int i=1; i<nums.length;i++) {
                output[i] = nums[i] + output[i-1];
            }
        }

        return output;

    }

}
