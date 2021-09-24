#include <vector>
using namespace std;

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

 struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution {
public:
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        if(head==nullptr){
            return vector<ListNode*>(k, nullptr);
        }
        int length = 0;
        for(auto* p = head; p!=nullptr; p = p->next){
            ++length;
        }

        vector<ListNode*> ans;

        int base_length = length / k;  //3
        int extra_num = length % k;    //1
        auto preNode = ListNode(-1,head); // dump node
        auto* pre = &preNode;
        auto* post=pre->next;
        for(int i=0; i<k; ++i){
            int num = 0;
            int loop_length= i<extra_num ? base_length+1 : base_length;

            if(pre!=nullptr)
                pre->next=nullptr;
            ans.push_back(post);

            while(num < loop_length){
                pre = post;
                post=post->next;
                num++;
            }
        }
        
        return ans;
    }
};
int main(){
    ListNode *p= new ListNode();
    auto head =  p;
    for(int i=1; i<10; ++i){
        p->val = i;
        p->next = new ListNode();
        p = p->next;
    }
    Solution s;
    auto ans = s.splitListToParts(head, 3);
}