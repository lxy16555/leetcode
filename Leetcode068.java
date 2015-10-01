package test;

//文字对齐模式，难点在思考清楚所有情况，方法为greedy，遍历所有，当超出范围则加入List并重新开始
public class Leetcode068 {
    //存储答案
    List<String> ans = new ArrayList<String>();
    
    //主方法，讨论base case然后调用greedy方法
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
    
    //greedy方法
    public void fullJstifyGreedy(String[] words, int maxWidth, int start) {
        //length存储当前长度，spacelength存储空格长度，newstart进入递归，count存储需要几个长空格，temp存储该次递归需要加入的字符串
        int length = words[start].length();
        int spacelength = 0;
        int newstart = 0;
        int count = 0;
        String temp = words[start];

        //从第二位开始循环
        for (int i=start+1; i<words.length; i++) {

            //当小于时更新length，当是最后一个时候加入temp，当大于时加入新String
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
        
	//当是最后一个时补上空格并加入，否则递归下一轮
        if (newstart == 0) {
            temp = temp + addSpace(maxWidth-length);
            ans.add(temp);
            return;
        } else
            fullJstifyGreedy(words, maxWidth, newstart);
    }
    
    //增加特定数量的空格
    public String addSpace(int a) {
        String temp = "";
        for (int i=0; i<a; i++)
            temp += ' ';
        return temp;
    }
}