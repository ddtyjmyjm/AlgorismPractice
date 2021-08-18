import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here
        
        int length = Math.max(s.length(),t.length());
        StringBuilder r = new StringBuilder(length+1); 
        int temp = 0;
        for(int x = 0; x<length; x++){
            char sC = '0';
            char tC = '0';
            if(s.length()-x-1>=0)
                sC = s.charAt(s.length()-x-1);
            if(t.length()-x-1>=0)
                tC = t.charAt(t.length()-x-1);
            int rI = sC-'0' + tC-'0' + temp;
            //String rS = String.valueOf(rI);
            r = r.insert(0,rI%10);
            if (rI<10){
                temp  = 0;
            }else{
                temp  = 1;
            }
        }
        if(temp==1){ 
            return (r.insert(0,1)).toString();
        }
        return r.toString();
    }
}