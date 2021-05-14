import java.util.*;


public class Solution {
    /**
     * 
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        if (arr==null) return -1;
        
        HashMap<Integer, Integer> table = new HashMap<>();
        int ans = 0;
        int pre = 0;
        int breakPoint = 0;
        for (int i = 0; i<arr.length; i++){
            if(!table.containsKey(arr[i])){
                table.put(arr[i],i);
                pre++;
                ans = Math.max(ans,pre);
            }else{
                pre = i - Math.max(table.get(arr[i]), breakPoint); 
                ans = Math.max(ans, pre);
                breakPoint = Math.max(breakPoint,table.get(arr[i]));
                table.replace(arr[i],i);
                
            }
            //ans = Math.max(ans,pre);
        }
        return ans;
    }
}