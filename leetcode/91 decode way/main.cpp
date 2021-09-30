#include <algorithm>
#include <cassert>
#include <string>
using namespace std;
class Solution {
public:
    int numDecodings(string s) {
        if (s.empty())
            return 0;
        int pre_char = 0;
        int single = 1;
        int twice = 0;
        int pre_twice = 0;
        for (char &c : s) {
            if (pre_char == 0 and c == '0')
                return 0;

            pre_twice = twice;
            if (pre_char == 1 or
                (pre_char == 2 and 0 <= c - '0' and c - '0' <= 6)) {
                twice = single;
            } else {
                twice = 0;
            }

            single = (c == '0') ? 0 : single + pre_twice;

            pre_char = c - '0';
        }
        return single + twice;
    }
};

int main() {
    Solution s;
    assert(s.numDecodings("2102") == 1);
}