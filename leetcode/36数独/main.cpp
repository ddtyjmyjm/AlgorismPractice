#include <vector>
using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        size_t const length = 9;
        bool grid[9][9] {{false,},};
        bool row[9][9] {{false,},};
        bool column[9][9] {{false,},};
        int grid_num = -1;
        int index = -1;
        for(size_t i=0; i<length; ++i){
            for(size_t j=0; j<length; ++j){
                if(board[i][j]=='.') continue;
                index = board[i][j]-'1';
                grid_num = 3*(i/3)+(j/3);
                if(!grid[grid_num][index]){
                    grid[grid_num][index]=true;
                }
                else {
                    return false;
                }
                    
                if(!row[i][index]){
                    row[i][index] = true;
                }else{
                    return false;
                }

                if(!column[j][index]){
                    column[j][index] = true;
                }else{
                    return false;
                }
                
            }
        }
        return true;
    }
};

int main(){
    Solution s {};
    vector<vector<char>> board = 
{{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};
    assert(s.isValidSudoku(board));
}