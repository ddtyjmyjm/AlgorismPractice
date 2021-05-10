import java.util.*;

public class LRU{
    public static void main(String args[]){
        Solution s = new Solution();
        int [][] ops = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int [] resutls = s.LRU(ops,3);
        
        System.out.println(Arrays.toString(resutls));
        
    }

    
} 




class Solution {
    private Node head = new Node(-1,-1); // most recent （不用null是为了减少后边移动节点操作的特殊情况）
    private Node tail = new Node(-1,-1); // least recent
    private Map<Integer,Node> mytable = new HashMap<>();
    private int k;
    private int curr_k = 0;
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // inital
        this.k = k;
        this.head.post=this.tail;
        this.tail.pre =this.head; 
        
        
        List<Integer> results = new ArrayList<>();
        for (int[] op : operators){
            if(op[0]==1){
                setOp(op[1],op[2]);
            }else if(op[0]==2){
                results.add(getOp(op[1]));
            }
        }
        
        // create a primative int array
        int[] array = new int[results.size()];
        for (int i=0; i< results.size();i++) array[i] = results.get(i);
        return array;
    }
    
    private void setOp(int key, int val){
        // if exist
        if(mytable.containsKey(key)){
            Node n = this.mytable.get(key);
            n.val = val;
            moveToHead(n);
            return;
        }
        
        if(this.curr_k == this.k){
            // need swap out
            Node rmN = this.tail.pre;
            mytable.remove(rmN.key);
            
            rmN.pre.post = this.tail;
            this.tail.pre = rmN.pre;
            rmN.pre = rmN.post = null;
        }else{
            this.curr_k++;
        }
        
        Node n = new Node(key,val);
        mytable.put(key,n);
       
        Node secN = head.post;
        head.post = secN.pre = n;
        n.pre = head;
        n.post = secN;
        return;
    }
    
    private int getOp(int key){
        if(!mytable.containsKey(key)){
            return -1;
        }
        
        Node n = mytable.get(key);
        moveToHead(n);
        return n.val;
    }
    
     private void moveToHead(Node k){
         Node preN = k.pre;
         Node postN = k.post;
         
         preN.post = postN;
         postN.pre = preN;
         
         Node secN = head.post;
         head.post = secN.pre = k;
         k.pre = head;
         k.post = secN;
     }
    
    
    static class Node{
        int key, val;
        Node pre=null, post=null;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}