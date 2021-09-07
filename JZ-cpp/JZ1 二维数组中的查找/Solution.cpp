#include "Solution.hpp"
using namespace std;

bool Solution::Find(int target, vector<vector<int>> array) {
  if (array.empty())
    return false;
  if (array[0].empty())
    return false;

  for (auto row : array) {
    if (row.front() > target)
      break;
    if (row.back() < target)
      continue;
    if (auto result = binary_search(row, 0, row.size() - 1, target); result) {
      return true;
    } else {
      continue;
    }
  }
  return false;
}

bool Solution::binary_search(vector<int> row, int l, int r, int target) {
  auto mid = l + (r - l) / 2;
  if (row[mid] == target)
    return true;
  if (r - l == 1)
    return row[r] == target;
  if (row[mid] < target) {
    return binary_search(row, mid + 1, r, target);
  } else {
    return binary_search(row, l, mid - 1, target);
  }
}
