#include <unordered_map>
#include <vector>
using namespace std;
class Solution {
public:
  int numberOfBoomerangs(vector<vector<int>> &points) {
    if (points.size() < 3)
      return 0;

    int ans{0};
    // auto cache =
    //     vector<vector<int>>(points.size(), vector<int>(points.size(), -1));
    for (size_t i = 0; i < points.size(); ++i) {
      auto hash = unordered_map<int, int>{};
      for (size_t j = 0; j < points.size(); ++j) {
        if (i == j)
          continue;
        // if (cache[i][j] == -1) {
        //   cache[i][j] =
        //       (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]) +
        //       (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]);
        //   cache[j][i] = cache[i][j];
        // }
        int distance =   
              (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]) +
              (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]);
      
        if (hash[distance] == 0) {
          ++hash[distance];
        }
        else {
          ans += 2* hash[distance];
          ++hash[distance];
        }
      }
    }
    return ans;
  }
};

int main() {
    auto points = vector<vector<int>>{{0, 0}, {1, 0}, {2, 0}}; 
    Solution s {};
    assert(s.numberOfBoomerangs(points) == 2);
}