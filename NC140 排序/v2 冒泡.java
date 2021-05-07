import java.util.Arrays;

// 冒泡
// 冒泡的重点在于每次扫描一遍，比较前后两个node进行交换。
// 第一次扫描一定会把最大的数带到最高位，顺便也会将其他node进行一定的排序;
// 第二次扫描一定会把第二大的数带到最高-1位，顺便排其他的数。
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort (int[] arr) {
        if(arr.length <2 ){
            // 0 or 1
            return arr;
        }
        
        int tmp;
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++) 
            {
                //swap
               if(arr[j]>arr[j+1]){
                   tmp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = tmp;
               }
            }
        }
        return arr;
    }
}