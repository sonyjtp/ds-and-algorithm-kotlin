// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/707/traversals-trees-graphs/4691/
package leetcode.tree

import leetcode.tree.pojo.TreeNode


fun minDepth(root: TreeNode<Int>?): Int {
    if (root == null) return 0
    if (root.left == null) return  minDepth(root.right) + 1
    if (root.right == null) return  minDepth(root.left) + 1
    return minOf(minDepth(root.left), minDepth(root.right)) + 1
}



