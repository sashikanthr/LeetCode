package leetcode.algorithms.I.day4;

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.



Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:

Input: s = "God Ding"
Output: "doG gniD"



Constraints:

    1 <= s.length <= 5 * 104
    s contains printable ASCII characters.
    s does not contain any leading or trailing spaces.
    There is at least one word in s.
    All the words in s are separated by a single space.


 */

import java.util.Arrays;

public class ReverseWordsInAStringIII {

    public static void main(String[] args) {
        ReverseWordsInAStringIII reverse = new ReverseWordsInAStringIII();
        System.out.println(reverse.reverseWords("Let's take LeetCode contest"));
        System.out.println(reverse.reverseWords_Array("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        StringBuilder output = new StringBuilder();
        String[] strings = s.split(" ");
        for(String string:strings) {
            output.append(" ");
            output.append(reverse(string.toCharArray()));
        }

        return output.toString().replaceFirst(" ","");
    }

    private char[] reverse(char[] s) {
        int length = s.length - 1;
        for (int i = 0; i <= length / 2; i++) {
            char temp = s[i];
            s[i] = s[length - i];
            s[length - i] = temp;
        }
        return s;
    }

    /*
        Implementation with a char array. Much faster than the above implementation
     */

    public String reverseWords_Array(String s) {
        char[] c = s.toCharArray();
        int begin=0;
        for(int i=0;i<c.length;i++) {
            if(c[i]==' '){
                reverse(c,begin,i-1);
                begin = i+1;
            }
        }
        reverse(c,begin,c.length-1);
        return new String(c);
    }

    private void reverse(char[] s,int begin, int end) {
        while(begin <= end) {
            char temp = s[begin];
            s[begin++] = s[end];
            s[end--] = temp;

        }
    }
}
