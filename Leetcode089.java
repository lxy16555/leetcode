package test;

//��ֻ��һλ��˳��洢gray code���¼���get��λ���������<<���Զ����������Ʋ���
public class Leetcode089 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        
        for (int i=0; i<n; i++) {
            int front = 1;
            
            for (int j=0; j<i; j++)
                front = front << 1;
            
            for (int j=ans.size()-1; j>=0; j--) {
                ans.add(ans.get(j) + front);
            }
        }
        
        return ans;
    }
}