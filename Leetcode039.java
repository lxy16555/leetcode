package test;
import java.util.*;

//һ�����ظ�����������֮��Ϊtarget�����п��ܣ���ȱ������÷���
public class Leetcode039 {
	//���ڴ洢��ȷ����
    List<Integer> temp = new ArrayList<Integer>();
	
    //���������趨ansΪ�𰸣�arrays.sortΪ��������
    public List<List<Integer>> combinationSum(int[] candidates, int target) {	
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	dfsAlgorithm(candidates, ans, target, 0);
    	return ans;
    }
    
    //DFS�㷨ʵ��
    void dfsAlgorithm(int[] candidates, List<List<Integer>> ans, 
    		int target, int cur) {
    	
    	//��targetΪ��ʱ��ans�����ʱ��temp������ʱдans.add(temp)�᷵�ؿ�ֵ��Ϊ�Σ���
    	if (target == 0) {
    		ans.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	//���������鳤�Ȼ���targetС���㲻���룬����
    	if (cur >= candidates.length || target < 0)
    		return;
    	
    	//DFS���壬��С�����������
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
