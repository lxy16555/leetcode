package test;

//合并所有区间，遍历当有删除，没有则增加
public class Leetcode056 {
    public List<Interval> merge(List<Interval> intervals) {
        //存储答案
        List<Interval> ans = new ArrayList<Interval>();
        //遍历intervals
        for (Interval s : intervals) {
            //遍历已存储的结果，若可覆盖，改写s并删除已储存结果
            for (int i=ans.size()-1; i>=0; i--) {
        	Interval v = ans.get(i);
       		if (s.start <= v.end && s.end >= v.start) {
        	    s.start = s.start < v.start ? s.start : v.start;
            	    s.end = s.end > v.end ? s.end : v.end;
                    ans.remove(i);
        	}
            }
            ans.add(s);
        }
        
        return ans;
    }
}