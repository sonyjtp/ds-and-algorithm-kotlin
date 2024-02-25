//https://leetcode.com/problems/same-tree/description/
package leetcode.tree.dfs

import leetcode.tree.pojo.TreeNode
import java.util.*


// recursive
fun isSameTree(p: TreeNode<Int>?, q: TreeNode<Int>?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null || p.`val` != q.`val`) return false
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}


//iterative
fun isSameTreeIterative(p: TreeNode<Int>?, q: TreeNode<Int>?): Boolean {
    val stack = Stack<Pair<TreeNode<Int>?, TreeNode<Int>?>>()
    stack.push(Pair(p, q))
    while (stack.isNotEmpty()) {
        val pair = stack.pop()
        if (pair.first == null && pair.second == null) continue
        if (pair.first == null || pair.second == null) return false
        if (pair.first?.`val` != pair.second?.`val`) return false
        stack.push(Pair(pair.first?.left, pair.second?.left))
        stack.push(Pair(pair.first?.right, pair.second?.right))
    }
    return true
}

