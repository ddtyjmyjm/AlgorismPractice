#include <vector>
using namespace std;

class Solution {
public:
  int findPeakElement(vector<int> &nums) {
    if (nums.size() == 1) {
      return 0;
    }
    int left = 0;
    int right = nums.size() - 1;

    while (left <= right) {
      auto mid = (right - left) / 2 + left;
      if (mid == 0) {
        if (nums[mid] > nums[mid + 1])
          return mid;
        left = mid + 1;
        continue;
      } else if (mid == nums.size() - 1) {
        if (nums[mid] > nums[mid - 1])
          return mid;
        right = mid;
        continue;
      } else if (nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1])
        return mid;

      if (nums[mid] < nums[mid - 1])
        right = mid;
      else
        left = mid + 1;
    }
    return 0;
  }
};

int main() {
  auto nums = vector<int>{1,2};
  Solution s{};
  assert(s.findPeakElement(nums) == 1);
}