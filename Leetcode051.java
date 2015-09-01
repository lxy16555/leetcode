package test;
import java.util.*;

//棋盘上横竖斜方向均不重叠，用回溯法遍历所有情况，注意此处优先画出各个可能的排列否则现画会超出时间
public class Leetcode051 {
    //存储可能排列
    List<String> temp = new ArrayList<String>();

    //生成所有字符串并存入相应数组
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

    //判断下一个插入点是否有效
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

    //插入有效解
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

    //主函数
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        String[] strs = generateStrings(n);

        findAns(ans, strs, n, 0);
        return ans;
    }
}