package test;

//����Unix������ļ�Ŀ¼
//Unix����"/./"�����壻"/../"�����ϲ�Ŀ¼��"///"����һ��"/"
public class Solution {
    //Ѱ����һ��"/"��λ��
    public int findNextSlash(String path, int loop) {
        for (int i=loop; i<path.length(); i++)
            if (path.charAt(i) == '/')
                return i+1;
        return path.length();
    }
    
    //��stack��ʽ�棬�޷�ʹ��List����leetcode��̨���ƣ�������ʵ��stack����stackSize��¼��ǰ����
    public String simplifyPath(String path) {
        int len = path.length();
        int[] stack = new int[len/2];
        int stackSize = 0;
        int loop = 1;
        int temp;
        
        //�������ַ�ʱѭ��
        while (loop < len) {
	    //����һ���ַ�Ϊ"/"��ɾ�����ַ����޸�len��������һ��ѭ��
            if (path.charAt(loop) == '/') {
                path = path.substring(0, loop) + path.substring(loop+1, len);
                len--;
	    //����һ���ַ�Ϊ"."���ж������
            } else if (path.charAt(loop) == '.') {
		//��loop�����һ���ַ�������ǰ���ַ�
                if (loop == len-1) {
                    path = path.substring(0, loop);
                    break;
		//��loop����������ַ�
                } else if (loop == len-2) {
		    //���������һ���ַ���"/"������ǰ���ַ�
                    if (path.charAt(loop+1) == '/') {
                        path = path.substring(0, loop);
                        break;
		    //�����һ���ַ���"."�������ϲ�Ŀ¼
                    } else if (path.charAt(loop+1) == '.') {
                        if (stackSize == 0)
                            return "/";
                        path = path.substring(0, stack[stackSize-1]);
                        break;
		    //�����һ���ַ��������ַ�������ʾһ����Ŀ¼������path
                    } else
                        break;
		//��loop�ǵ����������ַ�
                } else if (loop == len-3) {
		    //����������ַ���"./"�������ϼ�Ŀ¼
                    if (path.charAt(loop+1) == '.' && path.charAt(loop+2) == '/') {
                        if (stackSize == 0)
                            return "/";
                        path = path.substring(0, stack[stackSize-1]);
                        break;
		    //�������ڶ����ַ���"/"��ɾ��"./"������ѭ��
                    } else if (path.charAt(loop+1) == '/') {
                        path = path.substring(0, loop) + path.charAt(loop+2);
                        len -= 2;
		    //����Ϊ��Ŀ¼������path
                    } else
                        break;
		//��loop�����г���2���ַ�
                } else {
		    //����һ���ַ���"/"��ɾ��"./"������len������ѭ��
                    if (path.charAt(loop+1) == '/') {
                        path = path.substring(0, loop) + path.substring(loop+2, len);
                        len -= 2;
		    //���������ַ���"./"�������ϼ�Ŀ¼������stackSize��len��loop������ѭ��
                    } else if (path.charAt(loop+1) == '.' && path.charAt(loop+2) == '/') {
                        if (stackSize == 0) {
                            path = path.substring(loop+2, len);
                            len = len - loop - 2;
                            loop = 1;
                        } else {
                            temp = stack[stackSize-1];
                            path = path.substring(0, temp) + path.substring(loop+3, len);
                            len = len - (loop - temp) - 3;
                            loop = temp;
                            stackSize--;
                        }
		    //����Ϊ��Ŀ¼������stack��stackSize���ҵ���һ��"/"������ѭ��
                    } else {
                        stack[stackSize] = loop;
                        stackSize++;
                        loop = findNextSlash(path, loop);
                    }
                }
	    //Ϊ��Ŀ¼������stack��stackSize���ҵ���һ��"/"������ѭ��
            } else {
                stack[stackSize] = loop;
                stackSize++;
                loop = findNextSlash(path, loop);
            }
        }
        
	//��path����Ϊ1������path
        if (path.length() == 1)
            return path;
        
	//ȥ�����һ��"/"
        if (path.charAt(path.length()-1) == '/')
            return path.substring(0, path.length()-1);
        return path;
    }
}