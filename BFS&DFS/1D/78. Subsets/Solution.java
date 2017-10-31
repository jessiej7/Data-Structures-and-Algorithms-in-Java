//BFS
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for( int num : nums ){
            int size = res.size();
            for( int i = 0 ; i < size ; i++ ){
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }
}

// DFS
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0) return res;
        helper(res,new ArrayList<>(),nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<Integer>(list));
        for(int i=pos;i<nums.length;i++){
            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size() -1);
        }
    }
}



// Follow-Up:Multiplication
public class Solution {
    public List<Integer> subsets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for( int num : nums ){
            Set<Integer> temp = new HashSet<>();
            for( int i : set ){
                temp.add(i*num);
            }
            set.add(num);
            set.addAll(temp);
        }
        //set.add(0);
        return new ArrayList<>(set);
    }
}