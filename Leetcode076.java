package test;

//���ַ���s����С�İ��������ַ���t�����ַ���������
public class Leetcode076 {
    //������hashmap�������⣬����ֵ�ԣ���tmap��ʾÿ���ַ��Լ����ڵĸ�������smap��ʾ�ַ���s�е�ǰ�����ĸ���
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
	
	//��ʼ����smap����key��ֵ����0��tmap�������
        for (int i=0; i<t.length(); i++) {
            if (tmap.containsKey(t.charAt(i)))
                tmap.put(t.charAt(i), tmap.get(t.charAt(i))+1);
            else {
                smap.put(t.charAt(i), 0);
                tmap.put(t.charAt(i), 1);
            }
        }
        
	//count��ʾ�Ѵ���ĸ�����begin��ʾ��ʼλ�ã�len��ʾ��ǰ���Žⳤ�ȣ�startpoint��¼��ǰ���ŵ���ʼλ��
        int count = 0, begin = 0, len = s.length()+1, startpoint = -1;
        
	//ѭ��������������ַ�key��smap��value��1����count����t�ַ�������ʱ���Ҹý���ʼ�㣬��ɾ����ʼ�㣬������һ�ο�ʼΪ+1λ��
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