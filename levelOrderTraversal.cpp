#include <iostream>
#include <queue>
#include <unordered_set>
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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if(!root) { return res; }
        //if(!root->left && !root->right) { res.push_back({root->val}); return res; }

        queue<TreeNode*> q;
        q.push(root);

        while(!q.empty()) {
            int levelSize = q.size(); // how many are in this level
            vector<int> eachLevel;
            
            for(int i = 0; i < levelSize; ++i) { // more elements will be in queue, but only these many should be added to eachLevel vector
                TreeNode* curr = q.front();
                q.pop();
                eachLevel.push_back(curr->val);
                if(curr->left) {
                    q.push(curr->left);
                }
                if(curr->right) {
                    q.push(curr->right);
                }
            }
            res.push_back(eachLevel); // add to res
        }

        return res;
    }

};

int main() {
    Solution s;
    TreeNode* root = new TreeNode(1, new TreeNode(2, new TreeNode(4, nullptr, nullptr), nullptr), new TreeNode(3, nullptr, new TreeNode(5, nullptr, nullptr)));
    vector<vector<int>> res = s.levelOrder(root);
    for(const auto &el : res) { // prints each level on each line
        for(const auto&e : el) {
            cout << e << " ";
        }
        cout << endl;
    }
        //     1
        //    / \
        //   2   3
        //  / \ / \
        // 4       5
        // prints 1, 2 3, 4 5 on different lines
}