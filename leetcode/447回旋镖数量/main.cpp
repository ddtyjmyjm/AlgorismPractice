#include <unordered_map>
#include <vector>
using namespace std;
class Solution {
public:
  int numberOfBoomerangs(vector<vector<int>> &points) {
    // if (points.size() < 3)
    //   return 0;

    int ans{0};
    for (auto &i : points) {
      auto hash = unordered_map<int, int>{};
      for (auto &j : points) {
        int distance =
            (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
        ++hash[distance];
      }
      for (auto &[_, m] : hash) {
        ans += m * (m - 1);
      }
    }
    return ans;
  }
};

int main() {
  auto points = vector<vector<int>>{{0, 0}, {1, 0}, {2, 0}};
  Solution s{};
  assert(s.numberOfBoomerangs(points) == 2);
}