import java.util.*;

public class Solution {
    /**
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray (int[] arr) {
        if(arr == null || arr.length == 0)
            return -1;
        int preMax = arr[0]; // preMax 保存最大累加和
        int pre = 0;    // pre 保留最近子数组累加和
        for(int i = 0 ; i<arr.length ; i++)
        {
            pre += arr[i];
            preMax =  Math.max(pre,preMax); // 只有arr[i]为正preMax才可能改变
            // 当最近子数组的和 小于0时，需要分离，即 pre=0
            pre = Math.max(pre,0);          // 只有arr[i]为负pre  才可能改变
        }
        return preMax;
    }
}