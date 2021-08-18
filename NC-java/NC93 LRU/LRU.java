import java.util.*;

public class LRU{
    public static void main(String args[]){
        Solution3 s = new Solution3();
        int [][] ops = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int [] resutls = s.LRU(ops,3);
        
        System.out.println(Arrays.toString(resutls));
        
    }

    
} 




