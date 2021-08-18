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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addFirst(root);
        int cnt=0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode t = queue.poll();
                //queue.remove(levelNum-i-1);
                if (t.left != null)
                    queue.addLast(t.left);
                if (t.right != null)
                    queue.addLast(t.right);
                if(cnt%2==0) 
                    level.add(t.val);
                else
                    level.add(0,t.val);
            }
            res.add(level);
            cnt++;
        }
        return res;
    }
}