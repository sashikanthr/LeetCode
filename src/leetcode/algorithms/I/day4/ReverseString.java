package leetcode.algorithms.I.day4;

/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]



Constraints:

    1 <= s.length <= 105
    s[i] is a printable ascii character.


 */

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString_leetcode("hello".toCharArray());
        reverseString.reverseString(new char[]{'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'});
    }

    public void reverseString(char[] s) {
        int length = s.length - 1;
        for (int i = 0; i <= length / 2; i++) {
            char temp = s[i];
            s[i] = s[length - i];
            s[length - i] = temp;
        }
    }

    //Alternate implementation - leetcode

    public void reverseString_leetcode(char[] s) {
        int start=0;
        int end=s.length-1;
        while(start<=end) {
            char temp = s[start];
            s[start] = s[end];
            s[end]=temp;
            start++;
            end--;
        }
    }
}
