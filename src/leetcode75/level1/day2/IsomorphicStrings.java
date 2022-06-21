package leetcode75.level1.day2;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"
Output: true

Example 2:

Input: s = "foo", t = "bar"
Output: false

Example 3:

Input: s = "paper", t = "title"
Output: true



Constraints:

    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.


 */

public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings obj = new IsomorphicStrings();
        System.out.println(obj.isIsomorphic("badc","baba"));
        System.out.println(obj.isIsomorphic("foo","bar"));
        System.out.println(obj.isIsomorphic("paper","title"));
        System.out.println(obj.isIsomorphic("egg","add"));
    }


    public boolean isIsomorphic(String s, String t) {
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        int[] map = new int[128];
        boolean[] isCharUsed = new boolean[128];
        for(int i=0;i<target.length;i++) {
            if(map[target[i]]!=0 && map[target[i]]!=source[i]) {
                return false;
            } else if(map[target[i]]==0 && isCharUsed[source[i]]) {
                return false;
            } else {
                map[target[i]] = source[i];
                isCharUsed[source[i]] = true;
            }
        }
    return true;
    }


}
