public class Solution {
    int jumpFloor(int number) {
        
        if(number<2)
            return number;
        int f1=1;
        int f2=0;
        int f=0;
        for(int i=1;i<=number;++i)
            {
            f=f1+f2;
            f2=f1;
            f1=f;
        }
        return f;
    }
}