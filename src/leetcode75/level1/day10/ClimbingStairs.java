package leetcode75.level1.day10;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step



Constraints:

    1 <= n <= 45

 */

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {



    public static void main(String[] args) {
        System.out.println("-------------------Memoization-------------------------");
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(2));
        System.out.println(climbingStairs.climbStairs(3));
        System.out.println(climbingStairs.climbStairs(5));
        System.out.println(climbingStairs.climbStairs(45));
        System.out.println("-------------------Tabulation-------------------------");
        System.out.println(climbingStairs.climbStairs_memo(2));
        System.out.println(climbingStairs.climbStairs_memo(3));
        System.out.println(climbingStairs.climbStairs_memo(5));
        System.out.println(climbingStairs.climbStairs_memo(45));
    }


    //Fibonacci problem
    private final Map<Integer,Integer> memoMap = new HashMap<>();
    public int climbStairs_memo(int n) {
        if(memoMap.containsKey(n)) return memoMap.get(n);
        if(n==1 || n==0) return 1;
        memoMap.put(n, climbStairs_memo(n-1)+ climbStairs_memo(n-2));
        return memoMap.get(n);
    }

    public int climbStairs(int n) {
        //Fibonacci problem but the representation here is the number of ways it takes from an index to reach to zero
        //output[1] -> output[0] takes 1 way, output[2]- output[0] takes 2 ways. one directly and one through output[1]
        //The counter is updated when the corresponding index is  processed.

        int[] output = new int[n+1];
        output[0] = 1;
        for(int i=0;i<n;i++) {
            output[i+1]+=output[i];
            if(i+2<=n) {
                output[i+2]+=output[i];
            }
        }
        return output[n];
    }
}
