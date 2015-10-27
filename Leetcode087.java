package test;

//�������е��ַ������ӽڵ㽻���Ƿ�һ�£���DP��recursive������Ҫע�����TLE
public class Leetcode087 {
    //��hash�����洢��ֵ�ԣ���ʾ�ض�����string�Ƿ�һ��
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    
    //��Ѱ����hash���Ƿ��Ѵ棬ͨ�������ֶμ���recursive����
    public boolean isScramble(String s1, String s2) {
        if (map.containsKey(s1+s2))
            return map.get(s1+s2);
        
	//base condition������Ϊ1ʱ���������ַ��Ƿ�һ��
        if (s1.length() == 1) {
            map.put(s1+s2, s1.equals(s2));
            return (s1.equals(s2));
        }
        
	//ֱ�ӱȽ������ַ����Ƿ�һ��
        if (s1.equals(s2)) {
            map.put(s1+s2, true);
            return true;
        }
        
	//��һ��������������ַ��������ַ�������˵���ַ���Ŀһ�£����򷵻�false
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
        
	//recursive����
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