#include <cassert>
#include <list>
#include <map>
#include <queue>
#include <vector>
// todo : not finished
class Solution {
public:
  int findMaximizedCapital(int k, int w, std::vector<int> &profits,
                           std::vector<int> &capital) {
    // cache 存储预备capital的profile
    auto cache = std::map<int, std::vector<int>>{};
    for (std::size_t i = 0; int &c : capital) {
      std::vector<int> &value = cache[c];
      value.push_back(profits[i]);
      ++i;
    }

    auto queue =
        std::priority_queue<int>{};
    int pre_w = -1;

    auto iter = cache.begin();
    for (std::size_t i = 0; i < k; ++i) {
      if (pre_w < w) {
        while (iter!=cache.end() and iter->first <= w) {
          auto &vec = iter->second;
          for (auto &profile : vec) {
            queue.push(profile);
          }
          ++iter;
        }
      }
      if (queue.empty()) {
        break;
      }
      pre_w = w;
      w += queue.top();
      queue.pop();
    }
    return w;
  }
};

int main(){
    int k = 2;
    int w = 0;
    auto profits = std::vector<int>{1, 2, 3};
    auto  capital = std::vector<int>{0, 1, 1};
    Solution s {};
    int ans = s.findMaximizedCapital(k, w, profits, capital);
    assert(ans==4);
}