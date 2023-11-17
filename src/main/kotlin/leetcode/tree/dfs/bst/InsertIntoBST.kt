// https://tinyurl.com/leetcode026
package leetcode.tree.dfs.bst

import leetcode.tree.pojo.TreeNode


fun insertIntoBST(root: TreeNode<Int>?, value: Int): TreeNode<Int> {
    root ?: return TreeNode(value)
    if (root.`val` > value) root.left = insertIntoBST(root.left, value)
    else root.right = insertIntoBST(root.right, value)
    return root
}
