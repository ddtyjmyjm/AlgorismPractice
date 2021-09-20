#include <cassert>
#include <iostream>
class Solution
{
public:
    int dp(int target, int counter, int paste, int result)
    {
        if (target == result)
            return counter;
        else if (target < result)
            return INT_MAX;
        else
        {
            int counter1 = dp(target, counter + 1, paste, result + paste);
            int counter2 = dp(target, counter + 2, result, result + result);
            return std::min(counter1,counter2);
        }
    }
    int minSteps(int n)
    {
        return dp(n, 2, 1, 2);
    }
};

int main(){
    Solution s {};
    std::cout<<s.minSteps(4)<<std::endl;
}