#include <utility>
#include <cassert>
class Solution {
public:
  int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2,
                  int by2) {
    return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) -
           width(ax1, ax2, bx1, bx2) * width(ay1, ay2, by1, by2);
  }

  int width(int a1, int a2, int b1, int b2) {
    if (a1 > b1) {
      std::swap(a1, b1);
      std::swap(a2, b2);
    }

    if (a2 <= b1)
      return 0;
    else if (b1 < a2 and a2 <= b2)
      return a2 - b1;
    else
      return b2 - b1;
  }
};

int main() {
  Solution s;
  assert(s.computeArea(-2, -2, 2, 2, -1, -1, 1, 1) == 16);
}