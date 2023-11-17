// https://tinyurl.com/leetcode021
// find the longest left branch and the longest right branch of a node
package leetcode.tree.dfs

import leetcode.tree.pojo.TreeNode
import kotlin.math.max

private var diameter = 0

fun diameterOfBinaryTree(root: TreeNode<Int>?): Int {
        longestPath(root)
        return diameter
}

private fun longestPath(node: TreeNode<Int>?): Int {
        if (node == null) return 0
        val leftPath = longestPath(node.left)
        val rightPath = longestPath(node.right)
        diameter = max(diameter, leftPath + rightPath)
        return max(leftPath, rightPath) + 1
}
