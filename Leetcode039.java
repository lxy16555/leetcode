package test;
import java.util.*;

//一串不重复序列中数字之和为target的所有可能，深度遍历良好范例
public class Leetcode039 {
	//用于存储正确可能
    List<Integer> temp = new ArrayList<Integer>();
	
    //主函数，设定ans为答案，arrays.sort为数组排序
    public List<List<Integer>> combinationSum(int[] candidates, int target) {	
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	dfsAlgorithm(candidates, ans, target, 0);
    	return ans;
    }
    
    //DFS算法实现
    void dfsAlgorithm(int[] candidates, List<List<Integer>> ans, 
    		int target, int cur) {
    	
    	//当target为零时向ans插入此时的temp，若此时写ans.add(temp)会返回空值，为何？？
    	if (target == 0) {
    		ans.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	//若超出数组长度或者target小于零不插入，返回
    	if (cur >= candidates.length || target < 0)
    		return;
    	
    	//DFS本体，从小往大遍历迭代
    	for (int i=0; i<=target/candidates[cur]; i++) {
    		for (int j=0; j<i; j++)
    			temp.add(candidates[cur]);
    		dfsAlgorithm(candidates, ans, target-candidates[cur]*i, cur+1);
    		for (int j=0; j<i; j++)
    			temp.remove(temp.size()-1);
    	}
    }
    
    public static void main(String args[]) {
    	int[] candidates = {8,7,4,3};
    	int target = 11;
    	Leetcode039 test = new Leetcode039();
    	System.out.println(test.combinationSum(candidates, target));
    }
}
