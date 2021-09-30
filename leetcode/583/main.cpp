#include <string>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int minDistance(string word1, string word2) {
        auto vec = vector(2, vector(word2.size()+1, 0));
        int choose = 1;
        int pre = 0;
        for(size_t i=0; i<word1.size(); ++i){
            pre = choose;
            choose = i%2;

            for(size_t j=0; j<word2.size(); ++j){
                if(word1[i] == word2[j])
                    vec[choose][j+1] = vec[pre][j]+1;
                else
                    vec[choose][j+1] = std::max(vec[choose][j], vec[pre][j+1]);
            }
        }
        return word1.size()+word2.size()-2*vec[choose][word2.size()];

    }
};

int main(){
    string word1 = "sea";
    string word2 = "eat";
    Solution s{};
    std::cout<< s.minDistance(word1, word2)<<std::endl;
}