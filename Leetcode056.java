package test;

//�ϲ��������䣬��������ɾ����û��������
public class Leetcode056 {
    public List<Interval> merge(List<Interval> intervals) {
        //�洢��
        List<Interval> ans = new ArrayList<Interval>();
        //����intervals
        for (Interval s : intervals) {
            //�����Ѵ洢�Ľ�������ɸ��ǣ���дs��ɾ���Ѵ�����
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