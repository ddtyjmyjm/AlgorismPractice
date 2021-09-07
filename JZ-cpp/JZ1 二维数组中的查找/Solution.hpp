#include <vector>
class Solution {
public:
  bool Find(int target, std::vector<std::vector<int>> array);
  bool binary_search(std::vector<int> row, int l, int r, int target);
};