#include <numeric>
#include <vector>
using std::vector;
class Solution {
public:
  int minPathSum(vector<vector<int>> &grid) {
    // no guard (1 <= m, n <= 200)
    size_t const coloums = grid.size();
    size_t const rows = grid[0].size();
    // cache of former length
    auto cache = vector<vector<int>>(2, vector<int>(rows, 0));
    // single choice length
    std::partial_sum(grid[0].begin(), grid[0].end(), cache[0].begin());
    // next level
    size_t cache_now = 0, cache_pre = 0;
    for (size_t i = 1; i < coloums; ++i) {
      cache_now = i % 2;
      cache_pre = (cache_now + 1) % 2;
      
      cache[cache_now][0] = grid[i][0] +cache[cache_pre][0];
      for (size_t j = 1; j < rows; ++j) {
        cache[cache_now][j] =
            grid[i][j] + std::min(cache[cache_now][j-1], cache[cache_pre][j]);
      }
    }
    return cache[cache_now][rows-1];
  }
};
int main() {
  Solution s{};
  auto g = vector<vector<int>>{{1, 2},{1, 1}};
  auto ans = s.minPathSum(g);
  assert(ans == 3);
}
