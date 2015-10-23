package test;

//所有combination的题都可以用dfs解，找出n个数的所有k种排列
public class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    
    //dfs算法，start表示起始数字，n表示上限，k表示在start到n范围能取几个数，当k为0时取光，将temp加入ans
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