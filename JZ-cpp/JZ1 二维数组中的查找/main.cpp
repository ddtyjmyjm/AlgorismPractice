#include "Solution.hpp"
#include <vector>

int main() {
  auto const target = 5;
  auto const array = std::vector<std::vector<int>>{
      {1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
  Solution s{};
  assert(!s.Find(target, array));
}
