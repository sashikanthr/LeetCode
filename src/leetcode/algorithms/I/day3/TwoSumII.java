package leetcode.algorithms.I.day3;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.



Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].



Constraints:

    2 <= numbers.length <= 3 * 104
    -1000 <= numbers[i] <= 1000
    numbers is sorted in non-decreasing order.
    -1000 <= target <= 1000
    The tests are generated such that there is exactly one solution.


 */

import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {
        TwoSumII twoSum = new TwoSumII();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2,7,11,15}, 9)));
    }

/*    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        int left=-1;
        //int max = findMaxIndexLessThanTarget(numbers,target);
        int max = numbers.length;
        int right;
        do{
            left++;
            right = binarySearch(numbers,left,max,(target-numbers[left]));

        } while(right==-1);
        indices[0] = left+1;
        indices[1] = right+1;
        return indices;
    }*/

    private int[] twoSum(int[] numbers, int target) {
        return binarySearch(numbers, 0, numbers.length-1, target);
    }

    private int findMaxIndexLessThanTarget(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left < right) {
            int middle = left+(right-left)/2;
            if(numbers[right] <= target) return right;
            if(middle > target) left = middle+1;
            else right = right-1;
        }
        return right;
    }

    private int[] binarySearch(int[] numbers, int begin, int end, int initialTarget) {
        int[] indices = new int[2];
        int middle;
        int current;
        int left = begin;
        int target = initialTarget-numbers[begin];
        int right = end;
        while(left<=right) {
            middle = left+(right-left)/2;
            current = numbers[middle];
            if(current==target && begin!=middle) {
                indices[0] = begin+1;
                indices[1] = middle+1;
                return indices;
            }
            if(current>target) right = middle-1;
            else left = middle+1;
        }
        return binarySearch(numbers,++begin,end,initialTarget);
    }

}
