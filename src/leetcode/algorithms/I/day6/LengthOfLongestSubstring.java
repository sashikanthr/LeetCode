package leetcode.algorithms.I.day6;

/*
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.



Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.


 */

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring length = new LengthOfLongestSubstring();
        System.out.println(length.lengthOfLongestSubstring("au"));
        System.out.println(length.lengthOfLongestSubstring("pwwkew"));
        System.out.println(length.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        int begin = 0;
        int length = 1;
        int newLength;
        char[] chars = s.toCharArray();
        for(int i=1;i<chars.length;i++) {
            int index = indexOfRepeatedChar(chars,begin,i,chars[i]);
            if(index!=-1) {
                begin = index+1;
            } else {
                newLength = (i-begin)+1;
                if(newLength > length) length = newLength;
            }
        }
        newLength = (chars.length-begin);
        if(newLength > length) length = newLength;
        return length;
    }


    private int indexOfRepeatedChar(char[] chars, int begin, int end, char c) {
        for(int i=begin;i<end;i++) {
            if(c==chars[i]) return i;
        }
        return -1;
    }



}
