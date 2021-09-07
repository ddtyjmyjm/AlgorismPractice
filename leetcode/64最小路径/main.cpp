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
    auto cache = vector<int>(rows, std::numeric_limits<int>::max());
    cache[0] = 0;
    // next level
    for (size_t i = 0; i < coloums; ++i) {
      cache[0] = grid[i][0] +cache[0];
      for (size_t j = 1; j < rows; ++j) {
        cache[j] = grid[i][j] + std::min(cache[j-1], cache[j]);
      }
    }
    return cache[rows-1];
  }
};
int main() {
  Solution s{};
  auto g = vector<vector<int>>{{1, 3, 1},{1, 5, 1},{4, 2, 1}};
  auto ans = s.minPathSum(g);
  assert(ans == 7);
}
