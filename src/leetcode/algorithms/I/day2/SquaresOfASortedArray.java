package leetcode.algorithms.I.day2;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]



Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.


Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */

public class SquaresOfASortedArray {

    public static void main(String[] args) {

        SquaresOfASortedArray sortedArray = new SquaresOfASortedArray();
        for (int i : sortedArray.sortedSquares(new int[]{-7,-3,2,3,11})) {
            System.out.println(i);
        }
    }

    //Insertion sort. Need a better implementation once we learn new algorithms
    public int[] sortedSquares(int[] nums) {
        int[] sorted = new int[nums.length];
        int index = 0;
        if(nums.length > 0) {
            sorted[0] = nums[0]*nums[0];
        }
        int temp;
        for(int i=1;i<nums.length;i++) {
            sorted[i] = nums[i]*nums[i];
            for(int j = i; j>0; j--) {
                if(sorted[j] < sorted[j-1]) {
                 temp = sorted[j];
                 sorted[j] = sorted[j-1];
                 sorted[j-1] = temp;
                } else {
                    break;
                }
            }
        }

        return sorted;
    }
}


