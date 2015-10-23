package test;

//����combination���ⶼ������dfs�⣬�ҳ�n����������k������
public class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    
    //dfs�㷨��start��ʾ��ʼ���֣�n��ʾ���ޣ�k��ʾ��start��n��Χ��ȡ����������kΪ0ʱȡ�⣬��temp����ans
    public void dfsAlgorithm(int start, int n, int k, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for (int i=start; i<=n-k+1; i++) {
            temp.add(i);
            dfsAlgorithm(i+1, n, k-1, ans);
            temp.remove(temp.size()-1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (k == 0)
            return ans;
        dfsAlgorithm(1, n, k, ans);
        return ans;
    }
}