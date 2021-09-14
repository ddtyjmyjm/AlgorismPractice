#include <string>
#include <vector>
#include <unordered_map>
#include <set>
using namespace std;
class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        auto dict = std::unordered_map<char,std::set<int> >{};
        for(int i=0; i<s.size(); ++i){
            dict[s[i]].insert(i);
        }
        string ans {};
        bool success {false};
        for(auto &word: dictionary){
            success = false;
            int pos=-1;
            for(char c: word){
                success = false;
                if(dict.find(c) == dict.end()){
                    break;
                }
                for(int set_char: dict[c]){
                    if(pos < set_char){
                        pos = set_char;
                        success = true;
                        break;
                    }
                }
                if(!success) break;
            }
            if(success){
                if(word.size()  > ans.size()){
                    ans =  word;
                }else if(word.size()  == ans.size() and word<ans){
                    ans =  word;
                }
            }
        }

        return ans;
    }
};

int main(){
    auto s = "abce";
    auto dictionary = vector<string>{"abe","abc"};
    Solution sol{};
    assert(sol.findLongestWord(s,dictionary)=="abc");
}