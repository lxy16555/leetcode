package test;

//�������������ⷨ�����ݷ���٣�����һ���boolean���жϺ�����
public class Leetcode037 {
    public boolean isValidSudoku(char[][] board) {
    	//�����Ƿ����
        int[] temp = new int[9];
        initialize(temp);
        
        for (int i=0; i < 9; i++) {
        	//����
            for (int j=0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (temp[board[i][j]-49] == 1)
                        return false;
                    temp[board[i][j]-49] = 1;
                }
            }
            initialize(temp);
            
            //����
            for (int j=0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (temp[board[j][i]-49] == 1)
                        return false;
                    temp[board[j][i]-49] = 1;
                }
            }
            initialize(temp);
            
            //�Ź���
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
    
    //��ʼ���洢����
    void initialize(int[] nums) {
        for (int i=0; i < nums.length; i++)
            nums[i] = 0;
    }
    
    //���ݷ��жϲ�������Ƿ���ȷ
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
	
    //ֻ��һ�����ȵ�������
	public void solveSudoku(char[][] board) {
		isValidChoice(board);
	}
}
