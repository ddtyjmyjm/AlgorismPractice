#include <vector>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    int pathSum(TreeNode* root, int targetSum) {
        vector<int> heap {};
        return find(root, targetSum, heap);
    }

    int find(TreeNode* root, int targetSum, vector<int>heap){
        if(root==nullptr) return 0;
        std::transform(heap.begin(), heap.end(), heap.begin(), 
            [root](auto x){return root->val+x;});
        heap.push_back(root->val);
        int count = std::count(heap.begin(), heap.end(), targetSum);
        count += find(root->left, targetSum, heap);
        count += find(root->right, targetSum, heap);
        return count;
    }
};

int main(){
    TreeNode root (10);
    TreeNode a (1);
    TreeNode b (-1);
    root.left = &a;
    root.right = &b;
    Solution s;
    assert(s.pathSum(&root, 1)==1);
}