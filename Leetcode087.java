package test;

//二叉排列的字符经过子节点交换是否一致，用DP的recursive做，需要注意的是TLE
public class Leetcode087 {
    //用hash表来存储键值对，表示特定两个string是否一致
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    
    //先寻找在hash里是否已存，通过各种手段减少recursive次数
    public boolean isScramble(String s1, String s2) {
        if (map.containsKey(s1+s2))
            return map.get(s1+s2);
        
	//base condition当长度为1时返回两个字符是否一致
        if (s1.length() == 1) {
            map.put(s1+s2, s1.equals(s2));
            return (s1.equals(s2));
        }
        
	//直接比较两个字符串是否一致
        if (s1.equals(s2)) {
            map.put(s1+s2, true);
            return true;
        }
        
	//用一个数组遍历两个字符串，若字符抵消则说明字符数目一致，否则返回false
        int[] letter = new int[26];
        
        int len = s1.length();
        
        for (int i=0; i<len; i++) {
            letter[s1.charAt(i) - 'a']++;
            letter[s2.charAt(i) - 'a']--;
        }
        
        for (int i=0; i<26; i++) {
            if (letter[i] != 0) {
                map.put(s1+s2, false);
                return false;
            }
        }
        
	//recursive本体
        for (int i=1; i<len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len), s2.substring(i, len))) {
                map.put(s1+s2, true);
                return true;
            } else {
                map.put(s1+s2, false);
            }
            if (isScramble(s1.substring(0, i), s2.substring(len-i, len)) && isScramble(s1.substring(i, len), s2.substring(0, len-i))) {
                map.put(s1+s2, true);
                return true;
            } else {
                map.put(s1+s2, false);
            }
        }
        
        return false;
    }
}