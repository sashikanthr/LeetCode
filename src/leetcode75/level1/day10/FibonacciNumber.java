package leetcode75.level1.day10;

/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.

Given n, calculate F(n).



Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.



Constraints:

    0 <= n <= 30


 */

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    public static void main(String[] args) {

        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println("-------------Fibonacci using tabulation-------------");
        System.out.println(fibonacciNumber.fib_tabulation(0));
        System.out.println(fibonacciNumber.fib_tabulation(1));
        System.out.println(fibonacciNumber.fib_tabulation(2));
        System.out.println(fibonacciNumber.fib_tabulation(3));
        System.out.println(fibonacciNumber.fib_tabulation(4));
        System.out.println(fibonacciNumber.fib_tabulation(8));
        System.out.println(fibonacciNumber.fib_tabulation(30));

        System.out.println("-------------Fibonacci using memoization-------------");
        System.out.println(fibonacciNumber.fib_hashMap(0));
        System.out.println(fibonacciNumber.fib_hashMap(1));
        System.out.println(fibonacciNumber.fib_hashMap(2));
        System.out.println(fibonacciNumber.fib_hashMap(3));
        System.out.println(fibonacciNumber.fib_hashMap(4));
        System.out.println(fibonacciNumber.fib_hashMap(8));
        System.out.println(fibonacciNumber.fib_hashMap(30));
    }

    //Tabulation was faster than memoization by 1ms
    public int fib_tabulation(int n) {
        int[] output = new int[n+1];
        output[0] = 0;
        if(output.length >=2) {
            output[1] = 1;
        }
        for(int i=0;i<n;i++) {
            output[i+1]+=output[i];
            if(i+2<=n) {
                output[i+2]+=output[i];
            }
        }
        return output[n];
    }

    private final Map<Integer, Integer> memo = new HashMap<>();
    public int fib_hashMap(int n) {
        if(memo.containsKey(n)) return memo.get(n);
        if(n == 0) return 0;
        if(n == 1) return 1;
        memo.put(n,fib_hashMap(n-1)+fib_hashMap(n-2));
        return memo.get(n);
    }


}
