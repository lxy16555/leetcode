package test;

//��1,2,3���������һ��ѭ������ɣ���switch case���������ۣ���red��white��blue����ʶ
public class Leetcode075 {
    public void sortColors(int[] nums) {
        int red = -1;
        int white = -1;
        int blue = -1;
        int temp;
        
        for (int i=0; i<nums.length; i++) {
            switch (nums[i]) {
                case 0: 
                    if (white == -1) {
                        nums[red+1] = 0;
                        red++;
                        if (blue != -1) {
                            nums[i] = 2;
                            blue = i;
                        }
                    } else {
                        nums[red+1] = 0;
                        red++;
                        nums[white+1] = 1;
                        white++;
                        if (blue != -1) {
                            nums[i] = 2;
                            blue = i;
                        }
                    }
                    break;
                
                case 1:
                    if (blue == -1) {
                        white = i;
                    } else {
                        if (red == -1) {
                            nums[white+1] = 1;
                            white++;
                        } else {
                            if (white == -1) {
                                nums[red+1] = 1;
                                white = red+1;
                            } else {
                                nums[white+1] = 1;
                                white++;
                            }
                        }
                        nums[i] = 2;
                        blue = i;
                    }
                    break;
                
                case 2:
                    blue = i;
                    break;
            }
        }
    }
}