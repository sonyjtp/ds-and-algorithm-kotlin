//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
package leetcode.tree.dfs

import leetcode.tree.pojo.TreeNode


fun lowestCommonAncestor(root: TreeNode<Int>?, p: TreeNode<Int>?, q: TreeNode<Int>?): TreeNode<Int>? {
    if (root == null) return null
    if (root == p) return p
    if (root == q) return q
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)
    if (left != null && right != null) return root
    if (left != null) return  left
    return  right
}
