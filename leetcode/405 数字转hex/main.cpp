#include <string>
using namespace std;

class Solution {
public:
    string toHex(int num) {
        int const bytes=8;
        char value[bytes] = {0}; 
        unsigned int mask = 0x0000000f;
        for(int i = bytes; i > 0; --i){
            unsigned int out = (mask & num) >> 4*(bytes-i);
            if(0 <= out and out < 10){
                value[i-1] = out + '0';
            }else{
                value[i-1] = out - 10 + 'a';
            }
            mask = mask << 4;
        }
        for(int i=0; i<bytes; ++i){
            if (value[i]!='0')
                return string(&value[i], &value[0]+bytes);
        }
        return string("0");
    }
};

int main(){
    int num=26;
    Solution s;
    assert(s.toHex(num) == "1a");
}