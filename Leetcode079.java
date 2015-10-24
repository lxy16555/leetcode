package test;

//��ά�ַ�������Ѱ�����ڵ��ַ��������ݷ���DFS����
public class Leetcode079 {
    //����һ��������һ����������Χ�ĸ�����û�����������ҵ���word��һ���ַ���λ�ã����е�������temp��¼�Ƿ����
    public boolean backtracking(char[][] board, String word, int m, int n, int start, int[][] temp) {
        if (start == word.length()-1)
            return true;
        
        if (m<board.length-1 && temp[m+1][n] == 0 && board[m+1][n] == word.charAt(start+1)) {
            temp[m+1][n] = 1;
            if (backtracking(board, word, m+1, n, start+1, temp))
                return true;
            temp[m+1][n] = 0;
        }
        
        if (m>0 && temp[m-1][n] == 0 && board[m-1][n] == word.charAt(start+1)) {
            temp[m-1][n] = 1;
            if (backtracking(board, word, m-1, n, start+1, temp))
                return true;
            temp[m-1][n] = 0;
        }
                
        if (n<board[0].length-1 && temp[m][n+1] == 0 && board[m][n+1] == word.charAt(start+1)) {
            temp[m][n+1] = 1;
            if (backtracking(board, word, m, n+1, start+1, temp))
                return true;
            temp[m][n+1] = 0;
        }
        
        if (n>0 && temp[m][n-1] == 0 && board[m][n-1] == word.charAt(start+1)) {
            temp[m][n-1] = 1;
            if (backtracking(board, word, m, n-1, start+1, temp))
                return true;
            temp[m][n-1] = 0;
        }
        
        return false;
    }
    
    //Ѱ����㣬�Ӹ�λ�ý��л���
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    temp[i][j] = 1;
                    if (backtracking(board, word, i, j, 0, temp))
                        return true;
                    temp[i][j] = 0;
                }
            }
        }
        
        return false;
    }
}