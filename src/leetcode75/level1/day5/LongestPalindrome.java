package leetcode75.level1.day5;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.



Constraints:

    1 <= s.length <= 2000
    s consists of lowercase and/or uppercase English letters only.


 */

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        System.out.println(palindrome.longestPalindrome("abccccdd"));
        System.out.println(palindrome.longestPalindrome("ccc"));
        System.out.println(palindrome.longestPalindrome("a"));
        System.out.println(palindrome.longestPalindrome("AAAA"));
    }

    public int longestPalindrome(String s) {
        int output = 0;
        int[] alphabet = new int[58];
        char z = 'z';
        for(char c:s.toCharArray()) {
            alphabet[z-c]+=1;
        }
        for(int c: alphabet) {
            if(c>=2) {
                if(c%2==0) {
                    output+=c;
                } else {
                    output+=(c-1);
                }
            }
        }

        return output==s.length()?output:output+1;
    }
}
