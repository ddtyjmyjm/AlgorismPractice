import java.util.*;


public class SolutionV2 {
    /**
     * 
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        if (arr==null) return -1;
        if (arr.length<2) return arr.length;
        
        HashMap<Integer, Integer> table = new HashMap<>();
        int ans = 0;
        int breakPoint = 0;
        for (int i = 0; i<arr.length; i++){
            if(!table.containsKey(arr[i])){
                table.put(arr[i],i);
            }else{
                breakPoint = Math.max(table.get(arr[i])+1, breakPoint); 
                table.replace(arr[i],i);
            }
            ans = Math.max(ans, i - breakPoint +1);
        }
        return ans;
    }
}