package test;

//从字符串头跳跃到尾，比较每次能跳的格子里，下次能跳到的最远的一个，如果用迭代实现则时间复杂度为O(n^2)，用两个指针改进可为O(n)
public class Leetcode045 {
    //主函数
    public int jump(int[] nums) {
        //初始化，当数组长度为0或者1，不用跳
        if (nums.length <= 1)
            return 0;
        
        //改写数组，存储每一位能跳到的最远序号
        for (int i=0; i<nums.length-1; i++)
            nums[i] = (i+nums[i]) < (nums.length-1) ? (i+nums[i]) : (nums.length-1);
        
        //pre前一个，cur目前为止，count计数
        int pre = -1;
        int cur = 0;
        int count = 0;
        
        //从头遍历，若比cur跳的远，更新cur，若此时i超出pre的跳跃范围，更新pre并计数，若此位置能直接跳到结尾，直接返回count+1
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > nums[cur] && (pre == -1 || i > nums[pre])) {
                pre = cur;
                cur = i;
                count++;
            } else {
                if (nums[i] > nums[cur])
                    cur = i;
            }
            
            if (nums[i] == nums.length-1)
                return (count+1);
        }
        
        return 0;
    }
}