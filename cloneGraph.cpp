#include <iostream>
#include <set>
#include <map>
using namespace std;

// Definition for a Node.
struct Node {
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class Solution {
private:
    map<Node*, Node*> map;
public:
    Node* cloneGraph(Node* node) {
        if(!node) { return nullptr; }
        if(map.find(node) == map.end()) {
            map[node] = new Node(node->val);
            for(auto &ne: node->neighbors) {
                map[node]->neighbors.push_back(cloneGraph(ne));
            }
        }
        return map[node];
    }
};

int main() {

}