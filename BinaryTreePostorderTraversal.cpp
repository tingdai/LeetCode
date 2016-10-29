#include <iostream>
#include <vector>
using namespace std;

/**
 * Definition for a binary tree node.*/
struct TreeNode {
        int val;
        TreeNode *left;
        TreeNode *right;
        TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
    	vector<int> vecs;
    	vector<int>::iterator it;
    	if(root == NULL){
    		return vecs;
    	}
    	it = vecs.begin();
    	vecs.insert(it, root->val);
    	if(root->right != NULL){
    		vector<int> rightvecs = postorderTraversal(root->right);
    		rightvecs.reserve(vecs.size() + rightvecs.size());
    		rightvecs.insert(rightvecs.end(), vecs.begin(), vecs.end());
    		vecs = rightvecs;
    	}
    	if(root->left != NULL){
    		vector<int> leftvecs = postorderTraversal(root->left);
    		leftvecs.reserve(vecs.size() + leftvecs.size());
    		leftvecs.insert(leftvecs.end(), vecs.begin(), vecs.end());
    		vecs = leftvecs;
    	}
    	return vecs;
    }
};

int main(int argc, char* argv[]){
	Solution* solution = new Solution;
	TreeNode root = TreeNode(1);
	TreeNode left = TreeNode(2);
	root.left = &left;
	vector<int> vecs = solution->postorderTraversal(&root);
	for (vector<int>::const_iterator i = vecs.begin(); i != vecs.end(); ++i)
	    cout << *i << ' ';
}
