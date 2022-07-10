package leetcode.algorithms.I.day3;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]
Output: [0]



Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?
 */

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(new int[]{1});
        moveZeroes.moveZeroes_leetcode(new int[]{0,1,0,3,12});
    }

    public void moveZeroes(int[] nums) {
        int zeroIndex=-1;
        int temp;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0 && zeroIndex==-1) {
                zeroIndex = i;
            } else if(nums[i]!=0 && zeroIndex!=-1) {
                for(int j=i;j>zeroIndex;j--) {
                    temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                zeroIndex++;
            }
        }
    }

    //more elegant solution from LeetCode
    public void moveZeroes_leetcode(int[] nums) {
        int i=0;
        int j=0;
        while(j < nums.length) {
            if(nums[j]!=0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        while(i<nums.length) {
            nums[i]=0;
            i++;
        }

        for(int num:nums) {
            System.out.println(num);
        }
    }

}
