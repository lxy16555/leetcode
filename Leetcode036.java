package test;

//判断数独是否有效，横、竖、九宫格每个数字只出现一次
public class Leetcode036 {
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
}
