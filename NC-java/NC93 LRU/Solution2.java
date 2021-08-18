import java.util.*;

class Solution2 {
    private Node head = new Node(-1,-1); // most recent （不用null是为了减少后边移动节点操作的特殊情况）
    private Node tail = new Node(-1,-1); // least recent
    private Map<Integer,Node> mytable = new HashMap<>();
    private int k;
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
        if(getOp(key)!=-1){
            mytable.get(key).val = val;
            return;
        }
        
        if(mytable.size() == this.k){
            // need swap out
            Node rmN = this.tail.pre;
            mytable.remove(rmN.key);
            rmN.pre.post = this.tail;
            this.tail.pre = rmN.pre;
            rmN.pre = rmN.post = null;
        }
        
        Node n = new Node(key,val);
        mytable.put(key,n);
        moveToHead(n);
        return;
    }
    
    private int getOp(int key){
        if(!mytable.containsKey(key)){
            return -1;
        }
        
        Node n = mytable.get(key);
        n.pre.post = n.post;
        n.post.pre = n.pre;
        moveToHead(n);
        return n.val;
    }
    
     private void moveToHead(Node k){
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