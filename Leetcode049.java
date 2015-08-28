package test;
import java.util.*;

//�����ַ������飬���пɸ�дԪ�أ���һ�뷨��hashtable���ٶ�����������
public class Leetcode049 {
	//��дstringΪ�ֵ�˳�򣬴��key
	public String findKey(String s) {
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		return String.valueOf(temp);
	}
	
	//��Ҫ
    public List<List<String>> groupAnagrams(String[] strs) {
    	//���
    	List<List<String>> ans = new ArrayList<List<String>>();
    	
    	//���ֵ�˳������strs
    	Arrays.sort(strs);
    	
    	//�½���ϣ��
    	Hashtable<String, List<String>> temp = new Hashtable<String, List<String>>();
    	
    	//��������strs��P.S.�¼���get��forѭ������ʱ����for(V obj : Object)�����
    	for (String str : strs) {
    		String key = findKey(str);
    		if (!temp.containsKey(key))
    			temp.put(key, new ArrayList<String>());
    		temp.get(key).add(str);
    	}
    	
    	//������ϣ������ȡֵ������ans
    	for (List<String> s : temp.values())
    		ans.add(s);
    	
    	return ans;
    }
}