## 1.1.DFS
* Worst case : O(n^2)

```java
class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        return dfs(s, dict, new HashSet<>());
    }
    
    private boolean dfs(String s, List<String> dict, Set<String> set) {
        if (s.isEmpty()) return true;
        if (set.contains(s)) return false;
         
        set.add(s);
        for (String word : dict) {
            if (s.startsWith(word) && dfs(s.substring(word.length()), dict, set)) return true;
        }
        return false;
    }
}
```


## 1.2.DP
* dp[i] is true if ther a word in the dictionary that end at ith of s adnd is also true at the beginning of the word
* Time  : O(n^2)

1. Last step
	* dp[len-1] == true && dp[len-1-wordLen] == true

2. Transfer function
	* dp[i] ^= dp[j] && wordDict.contains(s.substring(j,i)

3. Initial and boundary conditions

	* dp[0] = true

4. Calculation order
	* Init dp[0]
	* Calculate dp[1],dp[2],... dp[len]
	* return dp[len]

```
s = "facebook"
words = ["face" , "book"]
dp
0 1 2 3 4 5 6 7 8 
t       t       t   
  f a c e 
         b o o k 
```


```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for( int i = 1 ; i < len + 1 ; i++){
           for( int j = 0 ; j < i ; j++ ){
               if( dp[j] && wordDict.contains(s.substring(j,i))){
                   dp[i] = true;
               }
           }  
           
        }
        return dp[len];
    }
}
```

## 2.1.Follow-Up - Find Min Break Number : DFS

```java
public class Solution {
    public int wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return 0;
        return helper(s, wordDict, new HashMap<>());
    }

    public int helper(String s, List<String> wordDict, Map<String,Integer> map) {
        if (s.isEmpty()) return 0;
        if (map.containsKey(s)) return map.get(s);

        int res = Integer.MAX_VALUE;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                int cur = helper(s.substring(word.length()), wordDict, map) + 1;
                res = Math.min(res, cur);
            }
        }
        map.put(s,res);
        return res;
    }
}

```
## 2.2.Follow-Up - Find Min Break Number : DP


```java
public class Solution {
    public int wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int[] dp = new int[len+1];
        Arrays.fill(dp, Integer.MAX_VALUE );
        dp[0] = 0;
        for( int i = 1 ; i < len + 1 ; i++){
            for( int j = 0 ; j < i ; j++ ){
                if( dp[j]!= Integer.MAX_VALUE && wordDict.contains(s.substring(j,i))){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }

        }
        return dp[len];
    }
}

```
