import java.util.*;


public class Solution {
    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        String result = "";
        int start = 0;
        int end = 1;
        while(end<=str2.length()){
            String subStr = str2.substring(start,end);
            // 直接用java提供的函数String.contains
            if(str1.contains(subStr)){
                result = subStr;
            }else{
                start++;
            }
            end++;
        }
        return result;
    }
}
