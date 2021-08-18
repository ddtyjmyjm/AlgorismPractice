import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param root TreeNode类 
     * @return int整型ArrayList<ArrayList<>>
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        
        if(root == null){
            return res;
        }
        count(root,0);
        return res;
        
    }
    
    public void count(TreeNode node, int level){
        if(level == res.size()){
            res.add(new ArrayList<Integer>());
        }
 
       ArrayList<Integer> list = res.get(level);
       list.add(node.val);
 
       if(node.left != null){
           count(node.left, level+1);
       }
 
       if(node.right != null){
           count(node.right, level+1);
       }
    }
}