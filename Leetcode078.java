package test;

//��һ����������������飬DFS���⣬��ͬ����Ϊ�˼ӿ��ٶȣ��ڱ�������ʱ�򼴿��Դ���temp��Ϊ��
public class Leetcode078 {
    List<Integer> temp = new ArrayList<Integer>();
    
    //DFS�㷨���ڱ���ʱ�������
    public void dfsAlgorithm(int[] nums, int startpoint, int k, List<List<Integer>> ans) {
        ans.add(new ArrayList<Integer>(temp));
        
        for (int i=startpoint; i<nums.length; i++) {
            temp.add(nums[i]);
            dfsAlgorithm(nums, i+1, k, ans);
            temp.remove(temp.size()-1);
        }
    }
    
    //����dfs
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        dfsAlgorithm(nums, 0, nums.length, ans);
        
        return ans;
    }
}