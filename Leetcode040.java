package test;
import java.util.*;

//与上一题类似，DFS，从头遍历
public class Leetcode040 {
	//存储有效结果
	List<Integer> temp = new ArrayList<Integer>();
	
	//主函数
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        DFS(candidates, ans, target, 0);
        return ans;
    }
    
    //DFS深度遍历
    public void DFS(int[] candidates, List<List<Integer>> ans, int target, int cur) {
    	//条件讨论
    	if (target == 0) {
    		ans.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	if (target < 0 || cur >= candidates.length)
    		return;
    	
    	//优先从最小数进行遍历，当与上一个数字相同则跳过
    	while (cur < candidates.length) {
    		temp.add(candidates[cur]);
    		DFS(candidates, ans, target-candidates[cur], cur+1);
    		temp.remove(temp.size()-1);
    		cur++;
    		while (cur < candidates.length && candidates[cur] == candidates[cur-1])
    			cur++;
    	}
    }
    
    public static void main(String args[]) {
    	int[] candidates = {1,1,2,3};
    	int target = 3;
    	Leetcode040 test = new Leetcode040();
    	System.out.println(test.combinationSum2(candidates, target));
    }
}
