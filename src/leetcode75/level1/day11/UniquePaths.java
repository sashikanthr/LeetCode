package leetcode75.level1.day11;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
        private Map<String,Integer> memo = new HashMap<>();

        public int uniquePaths(int m, int n) {

            String key = m+","+n;
            if(memo.containsKey(key)) return memo.get(key);
            if(m==1 || n==1) return 1;
            memo.put(key,uniquePaths(m,n-1) + uniquePaths(m-1,n));
            return memo.get(key);

        }


        //TODO need to implements this in tabulation to optmize it. The current code runs 13 ms.
}
