import java.util.*;


public class Solution {
    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        if (str1 == "" || str2 == "" || str1 == null || str2 == null)
            return "";
        int[][] table = new int[2][str1.length() + 1];

        int res = 0;
        int iMax = 0;
        ///int jMax = 0;
        for (int i = 1; i < str2.length() + 1; i++) {
            int pre = (i & 1) == 1 ? 0 : 1;
            int cur = (i & 1) == 0 ? 0 : 1;

            for (int j = 1; j < str1.length() + 1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    table[cur][j] = table[pre][j - 1] + 1;
                    if (table[cur][j] > res) {
                        res = table[cur][j];
                        iMax = i;
                        //jMax = j;
                    }
                }else {
                    table[cur][j]=0;
                }
            }
        }
        if (res == 0)
            return "";

        return str2.substring(iMax - res, iMax);
    }
}
//1NY92514w8AF5q1sul7MVNFZn
//t11NY92514w8AF5q1sul7MVNFZn