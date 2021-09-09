#include <string>
#include <vector>
#include <iostream>
using namespace std;
class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        // todo: need boundary guard
        auto ans = vector<string>{};
        for(size_t i = 0;;){

            /// step 1: find max words 
            size_t j = i; // find line end word
            int reserved_pedding = maxWidth - words[j].size(); // basic pedding (1 space)
            for(auto next = j+1; next < words.size(); ++next){
                auto next_with = words[next].size()+1;
                if(reserved_pedding < next_with)
                    break;
                reserved_pedding -= next_with;
                j = next;
            }

            /// step 2: pedding
            if (j >= words.size()-1 or j == i){
                // last line
                auto s = string{words[i++]};
                while(i<=j){
                    s.append(" ");
                    s.append(words[i]);
                    ++i;
                }
                s.append(string(reserved_pedding, ' '));
                ans.push_back(s);
                if(j >= words.size()-1)
                    break;
                else
                    continue;
            }

            auto basic_ped = reserved_pedding/(j-i) + 1;  // common ped 
            auto extra_ped_num = reserved_pedding%(j-i);  // numbers of common ped + 1
            auto s = string{words[i]};
            for(int n = 0; n<j-i ; ++n){
                s.append(string((n < extra_ped_num) ? basic_ped+1 : basic_ped, ' '));
                s.append(words[i+1+n]);
            }
            ans.push_back(s);
            i = j+1;
        }

        return ans;
    }
};

int main(){
    vector<string> words {"This", "is", "an", "example", "of", "text", "justification."};
    int maxWidth {16};
    Solution s {};
    auto ans = s.fullJustify(words, maxWidth);
    for(auto &s : ans){
        cout<< s << '\n';
    }
}