package test;

//Ѱ�����һ�����ʳ��ȣ��Ӻ���ǰ������ɾ�ո�
public class Leetcode058 {
    public int lengthOfLastWord(String s) {

        //��end�洢���һλ���ǿո���ַ�����λ��
        int end = -1;

        //��end��ʵ��ֵʱ�������ո���ɷ��س���
        for (int i=s.length()-1; i>=0; i--) {
            if (end == -1 && s.charAt(i) != ' ')
                end = i;
            if (end != -1 && s.charAt(i) == ' ')
                return end - i;
        }
        
        //���򷵻�end+1�ĳ���(ҪôΪ�գ�Ҫô���ַ���)
        return (end+1);
    }
}