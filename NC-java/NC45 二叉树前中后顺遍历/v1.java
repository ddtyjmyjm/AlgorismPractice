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
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        List<Integer> pL = preOrder(root);
        int [] pre = new int[pL.size()];
        for (int i=0; i< pL.size();i++) pre[i] = pL.get(i);
       
        List<Integer> mL = midOrder(root);
        int [] mid = new int[mL.size()];
        for (int i=0; i< mL.size();i++) mid[i] = mL.get(i);
        
        List<Integer> poL = postOrder(root);
        int [] post = new int[mL.size()];
        for (int i=0; i< poL.size();i++) post[i] = poL.get(i);
        
        return new int[][]{pre,mid,post};
    }
    
    private List<Integer> preOrder(TreeNode t){
        List<Integer> results = new ArrayList<>();
        results.add(t.val);
        if(t.left != null)
            results.addAll(preOrder(t.left));
        if(t.right != null)
            results.addAll(preOrder(t.right));
        return results;
    }
    
    private List<Integer> midOrder(TreeNode t){
        List<Integer> results = new ArrayList<>();
       
        if(t.left != null)
            results.addAll(midOrder(t.left));
        results.add(t.val);
        if(t.right != null)
            results.addAll(midOrder(t.right));
        return results;
    }
            
    private List<Integer> postOrder(TreeNode t){
        List<Integer> results = new ArrayList<>();

        if(t.left != null)
            results.addAll(postOrder(t.left));
        
        if(t.right != null)
            results.addAll(postOrder(t.right));
        results.add(t.val);
        return results;
    }
    
}