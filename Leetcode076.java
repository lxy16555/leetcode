package test;

//求字符串s中最小的包含所有字符串t的子字符串，难题
public class Leetcode076 {
    //用两个hashmap对照来解，即键值对，用tmap表示每个字符以及存在的个数，用smap表示字符串s中当前遍历的个数
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
	
	//初始化，smap所有key的值都是0，tmap计算个数
        for (int i=0; i<t.length(); i++) {
            if (tmap.containsKey(t.charAt(i)))
                tmap.put(t.charAt(i), tmap.get(t.charAt(i))+1);
            else {
                smap.put(t.charAt(i), 0);
                tmap.put(t.charAt(i), 1);
            }
        }
        
	//count表示已存入的个数，begin表示起始位置，len表示当前最优解长度，startpoint记录当前最优点起始位置
        int count = 0, begin = 0, len = s.length()+1, startpoint = -1;
        
	//循环，如果包含该字符key，smap中value加1，当count数到t字符串长度时，找该解起始点，并删除起始点，设置下一次开始为+1位置
        for (int i=0; i<s.length(); i++) {
            if (!smap.containsKey(s.charAt(i)))
                continue;
            smap.put(s.charAt(i), smap.get(s.charAt(i))+1);
            if (smap.get(s.charAt(i)) <= tmap.get(s.charAt(i)))
                count++;
            
            if (count == t.length()) {
                for (int j=begin; j<=i; j++) {
                    if (!smap.containsKey(s.charAt(j)))
                        continue;
                    if (smap.get(s.charAt(j)) > tmap.get(s.charAt(j))) {
                        smap.put(s.charAt(j), smap.get(s.charAt(j))-1);
                        continue;
                    } else {
                        begin = j + 1;
                        if (len > i - j) {
                            len = i - j;
                            startpoint = j;
                        }
                        smap.put(s.charAt(j), smap.get(s.charAt(j))-1);
                        count--;
                        break;
                    }
                }
            }
        }
        
        if (startpoint == -1)
            return "";
        return s.substring(startpoint, startpoint+len+1);
    }
}