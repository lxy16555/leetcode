package test;
import java.util.*;

//分组字符串数组，所有可复写元素，第一想法用hashtable，速度慢由于排序
public class Leetcode049 {
	//重写string为字典顺序，存成key
	public String findKey(String s) {
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		return String.valueOf(temp);
	}
	
	//主要
    public List<List<String>> groupAnagrams(String[] strs) {
    	//存答案
    	List<List<String>> ans = new ArrayList<List<String>>();
    	
    	//按字典顺序排列strs
    	Arrays.sort(strs);
    	
    	//新建哈希表
    	Hashtable<String, List<String>> temp = new Hashtable<String, List<String>>();
    	
    	//遍历所有strs，P.S.新技能get，for循环遍历时可用for(V obj : Object)代码简化
    	for (String str : strs) {
    		String key = findKey(str);
    		if (!temp.containsKey(key))
    			temp.put(key, new ArrayList<String>());
    		temp.get(key).add(str);
    	}
    	
    	//遍历哈希表所有取值，加入ans
    	for (List<String> s : temp.values())
    		ans.add(s);
    	
    	return ans;
    }
}