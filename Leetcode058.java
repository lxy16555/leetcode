package test;

//寻找最后一个单词长度，从后往前遍历，删空格
public class Leetcode058 {
    public int lengthOfLastWord(String s) {

        //用end存储最后一位不是空格的字符串的位置
        int end = -1;

        //当end有实际值时，遇到空格则可返回长度
        for (int i=s.length()-1; i>=0; i--) {
            if (end == -1 && s.charAt(i) != ' ')
                end = i;
            if (end != -1 && s.charAt(i) == ' ')
                return end - i;
        }
        
        //否则返回end+1的长度(要么为空，要么满字符串)
        return (end+1);
    }
}