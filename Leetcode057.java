package test;

//将新的interval插入并合并相同项
public class Leetcode057 {

    //用ans存储答案，比较interval，若不重复，则排入ans，否则更新newInterval，进行下一次比较
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<Interval>();
        int count = intervals.size();
        if (count == 0) {
            ans.add(newInterval);
            return ans;
        }
        
        for (int i=0; i<intervals.size(); i++) {
            Interval s = intervals.get(i);
            if (newInterval.start > s.end)
                ans.add(s);
            else {
                if (newInterval.end >= s.start) {
                    newInterval.start = newInterval.start < s.start ? newInterval.start : s.start;
                    newInterval.end = newInterval.end > s.end ? newInterval.end : s.end;
                } else {
                    count = i;
                    break;
                }
            }
        }
        ans.add(newInterval);
        
        for (int i=count; i<intervals.size(); i++)
            ans.add(intervals.get(i));
            
        return ans;
    }
}