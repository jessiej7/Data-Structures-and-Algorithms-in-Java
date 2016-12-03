// regular bfs
// tow slow !!!! 
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // bfs
        if(beginWord == null || endWord == null || wordList == null) return 0;
        if(wordList.size() == 0 ) return 0;
        return helper(beginWord, endWord, wordList);
    }
    private int helper(String beginWord, String endWord, Set<String> wordList){
  
        // save node in each level -> Queue<String>
        // Mark visited - Set<String>
        // Record path length - int steps
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        int steps = 0;
        
        queue.offer(beginWord);
        visited.add(beginWord);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            steps++;
            for(int i = 0 ; i < size ; i++ ){
                String curStr = queue.poll();
                // find candidate for next level
                for(int j = 0 ; j < curStr.length(); j++ ){
                    for( char k = 'a' ; k <= 'z' ; k++ ){
                        String  toStr = replace(curStr,j,k);
                        // check result first
                        if(toStr.equals(endWord)){
                            return ++steps;
                        }
                        // add to visited set and queue if it is in dictionary and not in visited
                        if(visited.add(toStr)&&wordList.contains(toStr)){
                            queue.offer(toStr);
                        }
                    }
                }
            }
        }
        return 0;
    }
    private String replace(String str, int i , char c ){
        char[] chs = str.toCharArray();
        chs[i] = c;
        return new String(chs);
    }
}

// optimized 
// two ds instead of two
// set instead of queue
// record two staring set
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // bfs
        if(beginWord == null || endWord == null || wordList == null) return 0;
        if(wordList.size() == 0 ) return 0;
        return helper(beginWord, endWord, wordList);
    }
    private int helper(String beginWord, String endWord, Set<String> wordList){
  
        // save node in each level -> Queue<String>
        // Mark visited - Set<String>
        // Record path length - int steps
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        int steps = 0;
        
        queue.offer(beginWord);
        visited.add(beginWord);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            steps++;
            for(int i = 0 ; i < size ; i++ ){
                String curStr = queue.poll();
                // find candidate for next level
                for(int j = 0 ; j < curStr.length(); j++ ){
                    for( char k = 'a' ; k <= 'z' ; k++ ){
                        String  toStr = replace(curStr,j,k);
                        // check result first
                        if(toStr.equals(endWord)){
                            return ++steps;
                        }
                        // add to visited set and queue if it is in dictionary and not in visited
                        if(visited.add(toStr)&&wordList.contains(toStr)){
                            queue.offer(toStr);
                        }
                    }
                }
            }
        }
        return 0;
    }
    private String replace(String str, int i , char c ){
        char[] chs = str.toCharArray();
        chs[i] = c;
        return new String(chs);
    }
}

