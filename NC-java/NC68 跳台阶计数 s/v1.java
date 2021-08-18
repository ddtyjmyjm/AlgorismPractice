public class Solution {
    public int jumpFloor(int target) {
        if(target<0)
            return 0;
        if(target==0)
            return 1;
        return jumpFloor(target-1)+ jumpFloor(target-2);
    }
}