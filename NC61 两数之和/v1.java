import java.util.*;


public class Solution {
    /**
     * 
     * @param numbers int整型一维数组 
     * @param target int整型 
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        
        HashMap <Integer,Integer> scanedTable = new HashMap<>();
        
        if(numbers.length == 0 || numbers.length == 1)
            return null;
        
        for (int i=0; i< numbers.length; i++){
            if(i == 0)
                scanedTable.put(numbers[i],i);
            else{
                int needN = target-numbers[i];
                if(scanedTable.containsKey(needN)){
                    int[] res = {scanedTable.get(needN)+1,i+1};
                    return res ;
                }else{
                    scanedTable.put(numbers[i],i);
                }
            }
        }
        
        return null;
    }
}