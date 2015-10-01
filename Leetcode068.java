package test;

//���ֶ���ģʽ���ѵ���˼������������������Ϊgreedy���������У���������Χ�����List�����¿�ʼ
public class Leetcode068 {
    //�洢��
    List<String> ans = new ArrayList<String>();
    
    //������������base caseȻ�����greedy����
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (maxWidth == 0) {
            ans.add("");
            return ans;
        }
        
        if (words[0].length() == 0) {
            ans.add(addSpace(maxWidth));
            return ans;
        }
        
        fullJstifyGreedy(words, maxWidth, 0);
        return ans;
    }
    
    //greedy����
    public void fullJstifyGreedy(String[] words, int maxWidth, int start) {
        //length�洢��ǰ���ȣ�spacelength�洢�ո񳤶ȣ�newstart����ݹ飬count�洢��Ҫ�������ո�temp�洢�ôεݹ���Ҫ������ַ���
        int length = words[start].length();
        int spacelength = 0;
        int newstart = 0;
        int count = 0;
        String temp = words[start];

        //�ӵڶ�λ��ʼѭ��
        for (int i=start+1; i<words.length; i++) {

            //��С��ʱ����length���������һ��ʱ�����temp��������ʱ������String
            if (length + 1 + words[i].length() <= maxWidth) {
                length = length + 1 + words[i].length();
                if (i == words.length-1) {
                    for (int j=start+1; j<=i; j++)
                        temp += ' ' + words[j];
                }
            } else {
                if (i-start > 1) {
                    spacelength = (maxWidth - length + i - 1 - start) / (i - start - 1);
                    count = (maxWidth - length + i - 1 - start) % (i - start - 1);
                    if (count > 0)
                        temp = temp + addSpace(1+spacelength);
                    else
                        temp = temp + addSpace(spacelength);
                } else
                    temp = temp + addSpace(maxWidth - length);
                
                for (int j=start+1; j<i; j++) {
                    temp = temp + words[j];
                    if (j != i-1) {
                        if (j-start < count)
                            temp = temp + addSpace(1 + spacelength);
                        else
                            temp = temp + addSpace(spacelength);
                    }
                }
                ans.add(temp);
                newstart = i;
                break;
            }
        }
        
	//�������һ��ʱ���Ͽո񲢼��룬����ݹ���һ��
        if (newstart == 0) {
            temp = temp + addSpace(maxWidth-length);
            ans.add(temp);
            return;
        } else
            fullJstifyGreedy(words, maxWidth, newstart);
    }
    
    //�����ض������Ŀո�
    public String addSpace(int a) {
        String temp = "";
        for (int i=0; i<a; i++)
            temp += ' ';
        return temp;
    }
}