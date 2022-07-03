package leetcode75.level1.day11;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
        private Map<String,Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,7));
    }

        public int uniquePaths_memo(int m, int n) {

            String key = m+","+n;
            if(memo.containsKey(key)) return memo.get(key);
            if(m==1 || n==1) return 1;
            memo.put(key,uniquePaths(m,n-1) + uniquePaths(m-1,n));
            return memo.get(key);

        }

        public int uniquePaths(int m, int n) {
            int[][] grid = new int[m][n];
            grid[0][0] = 1;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    int currrentCell = grid[i][j];
                    if(i+1<m) grid[i+1][j]+=currrentCell;
                    if(j+1<n) grid[i][j+1]+=currrentCell;
                }
            }

            return grid[m-1][n-1];
        }
}
