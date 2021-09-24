#include <stack>

/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};
*/
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};


class Solution {
public:
    // 循环(stack)的方法
    Node* flatten(Node* head) {
        std:: stack<Node*> waitting_list;
        waitting_list.push(head);
        Node dump = Node(); //dump
        Node* ans= &dump;
        Node* p = nullptr;
        while(!waitting_list.empty()){
            p = waitting_list.top();
            waitting_list.pop();
            if(p==nullptr) continue;

            ans->next = p;
            p->prev = ans;
            while(p!=nullptr and ans->child==nullptr){
                ans = p;
                p = p->next;
            }
            // meet child or at the end
            if(ans->child!=nullptr){
                ans->next=nullptr;
                if(p!=nullptr)  p->prev=nullptr;
                waitting_list.push(p);
                waitting_list.push(ans->child);
                ans->child=nullptr;
            }

        }
        if(dump.next!=nullptr) dump.next->prev=nullptr;
        return dump.next;
    }
};

int main(){
    auto n1 = Node();
    auto n2 = Node();
    auto n3 = Node();
//    auto n4 = Node();   
    n1.val=1;
    n1.child=&n2;
    n2.val=2;
    n2.child=&n3;
    n3.val=3;


    Solution s;
    auto ans = s.flatten(&n1);

}