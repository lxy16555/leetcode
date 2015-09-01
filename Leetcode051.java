package test;
import java.util.*;

//�����Ϻ���б��������ص����û��ݷ��������������ע��˴����Ȼ����������ܵ����з����ֻ��ᳬ��ʱ��
public class Leetcode051 {
    //�洢��������
    List<String> temp = new ArrayList<String>();

    //���������ַ�����������Ӧ����
    public String[] generateStrings(int n) {
        String[] strs = new String[n];
        String s = "";
        s += 'Q';
        for (int i=1; i<n; i++)
            s += '.';
        for (int i=0; i<n; i++) {
            strs[i] = s.substring(0, n);
            s = '.' + s;
        }
        return strs;
    }

    //�ж���һ��������Ƿ���Ч
    public boolean isValid(List<String> temp, int row, int column) {
        for (int i=0; i<temp.size(); i++) {
            String s = temp.get(i);
            int findQ = 0;
            while (s.charAt(findQ) != 'Q')
                findQ++;
            if (column == findQ || column-row == findQ-i || column+row == findQ+i)
                return false;
            }
        return true;
    }

    //������Ч��
    public void findAns(List<List<String>> ans, String[] strs, int n, int count) {
        if (count == n) {
            ans.add(new ArrayList<String>(temp));
            return;
        }

        for (int i=0; i<n; i++) {
            if (isValid(temp, count, i)) {
                temp.add(strs[i]);
                count++;
                findAns(ans, strs, n, count);
            } else 
                continue;
            temp.remove(temp.size()-1);
            count--;
        }
    }

    //������
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        String[] strs = generateStrings(n);

        findAns(ans, strs, n, 0);
        return ans;
    }
}