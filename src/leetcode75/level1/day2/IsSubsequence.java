package leetcode75.level1.day2;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false



Constraints:

    0 <= s.length <= 100
    0 <= t.length <= 104
    s and t consist only of lowercase English letters.


Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */

public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("aaaaa", "bbaaa"));
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence.isSubsequence("axc", "ahbgdc"));
    }


    public boolean isSubsequence(String s, String t) {
        int[] positionIndex = new int[s.length()];
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        int lastPositionIndex = 0;
        for(int i=0;i<source.length;i++) {
            positionIndex[i] = -1;
            for(int j=lastPositionIndex;j<target.length;j++) {
                if(source[i]==target[j]) {
                    positionIndex[i] = j;
                    lastPositionIndex = j+1;
                    break;
                }
            }
            if(positionIndex[i]==-1) {
                return false;
            }
        }
        for(int i=1;i<positionIndex.length;i++) {
            if(positionIndex[i] < positionIndex[i-1]) {
                return false;
            }
        }
        return true;
    }

}
