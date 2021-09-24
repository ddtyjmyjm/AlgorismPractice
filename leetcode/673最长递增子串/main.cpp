#include <vector>
using namespace std;

class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        if(nums.size()==0) return 0;
        auto length_vec = vector<pair<int,int>>(nums.size(),{0,0}); //{formor length , paths}
        length_vec[0] = std::pair<int,int>(1,1);
        int longest_length = 1;
        int longest_path = 1;
        for(size_t i=1 ; i<nums.size(); ++i){
            auto length = 0;
            auto path = 1;
            for(size_t j=0; j<i; ++j){
                auto [j_length, j_path] = length_vec[j];
                if(nums[i]>nums[j]){
                    if(length<j_length){
                        length = j_length;
                        path = j_path;
                    }else if(length==j_length){
                        path += j_path;
                    }
                }
            }
            length++;
            if(length>longest_length) {
                longest_length = length;
                longest_path = path; }
            else if(length==longest_length) 
            {
                longest_length = length;
                longest_path += path;
            }
            length_vec[i] = std::pair<int,int>{length,path};
        }
        return longest_path;
    }
};

int main(){
    Solution s;
    auto nums = vector<int>{1,2,4,3,5,4,7,2};
    auto result = 3;
    assert(s.findNumberOfLIS(nums)==result);
}