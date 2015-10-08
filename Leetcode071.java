package test;

//按照Unix规则简化文件目录
//Unix规则："/./"无意义；"/../"返回上层目录；"///"等于一个"/"
public class Solution {
    //寻找下一个"/"的位置
    public int findNextSlash(String path, int loop) {
        for (int i=loop; i<path.length(); i++)
            if (path.charAt(i) == '/')
                return i+1;
        return path.length();
    }
    
    //用stack形式存，无法使用List由于leetcode后台限制，用数组实现stack，用stackSize记录当前个数
    public String simplifyPath(String path) {
        int len = path.length();
        int[] stack = new int[len/2];
        int stackSize = 0;
        int loop = 1;
        int temp;
        
        //当仍有字符时循环
        while (loop < len) {
	    //当下一个字符为"/"，删除该字符，修改len，进行下一次循环
            if (path.charAt(loop) == '/') {
                path = path.substring(0, loop) + path.substring(loop+1, len);
                len--;
	    //当下一个字符为"."，有多种情况
            } else if (path.charAt(loop) == '.') {
		//当loop是最后一个字符，返回前串字符
                if (loop == len-1) {
                    path = path.substring(0, loop);
                    break;
		//当loop是最后两个字符
                } else if (loop == len-2) {
		    //当倒数最后一个字符是"/"，返回前串字符
                    if (path.charAt(loop+1) == '/') {
                        path = path.substring(0, loop);
                        break;
		    //当最后一个字符是"."，返回上层目录
                    } else if (path.charAt(loop+1) == '.') {
                        if (stackSize == 0)
                            return "/";
                        path = path.substring(0, stack[stackSize-1]);
                        break;
		    //当最后一个字符是其他字符，即表示一个新目录，返回path
                    } else
                        break;
		//当loop是倒数第三个字符
                } else if (loop == len-3) {
		    //当最后两个字符是"./"，返回上级目录
                    if (path.charAt(loop+1) == '.' && path.charAt(loop+2) == '/') {
                        if (stackSize == 0)
                            return "/";
                        path = path.substring(0, stack[stackSize-1]);
                        break;
		    //当倒数第二个字符是"/"，删除"./"并继续循环
                    } else if (path.charAt(loop+1) == '/') {
                        path = path.substring(0, loop) + path.charAt(loop+2);
                        len -= 2;
		    //否则为新目录，返回path
                    } else
                        break;
		//当loop后面有超过2个字符
                } else {
		    //当后一个字符是"/"，删除"./"，更新len，继续循环
                    if (path.charAt(loop+1) == '/') {
                        path = path.substring(0, loop) + path.substring(loop+2, len);
                        len -= 2;
		    //当后两个字符是"./"，返回上级目录，更新stackSize，len，loop，继续循环
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
		    //否则为新目录，更新stack，stackSize，找到下一个"/"，继续循环
                    } else {
                        stack[stackSize] = loop;
                        stackSize++;
                        loop = findNextSlash(path, loop);
                    }
                }
	    //为新目录，更新stack，stackSize，找到下一个"/"，继续循环
            } else {
                stack[stackSize] = loop;
                stackSize++;
                loop = findNextSlash(path, loop);
            }
        }
        
	//若path长度为1，返回path
        if (path.length() == 1)
            return path;
        
	//去掉最后一个"/"
        if (path.charAt(path.length()-1) == '/')
            return path.substring(0, path.length()-1);
        return path;
    }
}