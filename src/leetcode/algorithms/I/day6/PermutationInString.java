package leetcode.algorithms.I.day6;

/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false



Constraints:

    1 <= s1.length, s2.length <= 104
    s1 and s2 consist of lowercase English letters.


 */

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion_leetcode("hello","ooolleoooleh"));
        System.out.println(permutationInString.checkInclusion("r","pilmtnzraxj"));
        System.out.println(permutationInString.checkInclusion("abc","bbbca"));
        System.out.println(permutationInString.checkInclusion("ab","eidboaoo"));
        System.out.println(permutationInString.checkInclusion("ab","eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] frequencies = new int[26];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(char c:c1) {
            frequencies['z'-c]++;
        }
        int begin=0;
        int end = begin+c1.length;
        boolean isSubStringFound = false;
        while(!isSubStringFound && end<=c2.length) {
            isSubStringFound = true;
            int[] frequencies_c2 = frequencies.clone(); //Can copy the elements with a separate loop also.
            for(int i=begin;i<end;i++) {
                int charIndex = 'z'-c2[i];
                frequencies_c2[charIndex]--;
                if(frequencies_c2[charIndex]<0) {
                    isSubStringFound = false;
                    break;
                }
            }
            begin+=1;
            end = begin+c1.length;
        }

        return isSubStringFound;
    }


    //Leetcode implementation that takes only 2ms. My own implementation took 71 ms.

    public boolean checkInclusion_leetcode(String s1, String s2) {

        // Approach 1: Expand window
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int start = 0, end = 0;

        int[] str1Freq = new int[26];

        //Update the char frequency
        for (char c : str1) {
            str1Freq[c-'a']++;
        }

        while (end < str2.length) {
            char currChar = str2[end++];
            //Decrement the frequency of the current char and increment the end index
            --str1Freq[currChar - 'a'];
            //If the frequency is less than zero, the required number of characters are not present in s1
            while (str1Freq[currChar - 'a'] < 0 && start < end)
            {
                //Required number of chars not present. Increment the characters from the start index till current char as these were decremented in previous iterations
                ++str1Freq[str2[start++] - 'a'];
            }
            //Start-End matches the length only when chars of s1 are available in s2
            if (end - start == str1.length) {
                return true;
            }
        }
        return false;
    }
}
