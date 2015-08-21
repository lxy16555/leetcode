package test;

//解数独，暴力解法，回溯法穷举，用上一题的boolean来判断合理性
public class Leetcode037 {
    public boolean isValidSudoku(char[][] board) {
    	//储存是否出现
        int[] temp = new int[9];
        initialize(temp);
        
        for (int i=0; i < 9; i++) {
        	//横排
            for (int j=0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (temp[board[i][j]-49] == 1)
                        return false;
                    temp[board[i][j]-49] = 1;
                }
            }
            initialize(temp);
            
            //竖排
            for (int j=0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (temp[board[j][i]-49] == 1)
                        return false;
                    temp[board[j][i]-49] = 1;
                }
            }
            initialize(temp);
            
            //九宫格
            for (int j=0; j<9; j++) {
                int index1 = (i / 3) * 3;
                int index2 = (i % 3) * 3;
                if (board[index1 + j / 3][index2 + j % 3] != '.') {
                    if (temp[board[index1 + j / 3][index2 + j % 3]-49] == 1)
                        return false;
                    temp[board[index1 + j / 3][index2 + j % 3]-49] = 1;
                }
            }
            initialize(temp);
        }
        
        return true;
    }
    
    //初始化存储数组
    void initialize(int[] nums) {
        for (int i=0; i < nums.length; i++)
            nums[i] = 0;
    }
    
    //回溯法判断插入的数是否正确
    public boolean isValidChoice(char[][] board) {
    	for (int i=0; i<9; i++)
    		for (int j=0; j<9; j++) {
    			if (board[i][j] == '.') {
    				for (int k=1; k<=9; k++) {
    					board[i][j] = (char) (48 + k);
    					if (isValidSudoku(board)) {
    						if (isValidChoice(board))
    							return true;
    					}
    					board[i][j] = '.';
    				}
    				return false;
    			}
    		}
    	return true;
    }
	
    //只是一个卖萌的主函数
	public void solveSudoku(char[][] board) {
		isValidChoice(board);
	}
}
