//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
package leetcode.tree.dfs

import leetcode.tree.pojo.TreeNode
import java.util.Stack
import kotlin.math.max



fun goodNodes(root: TreeNode<Int>?): Int {
    return countAndCheck(root)
}

fun countAndCheck(root: TreeNode<Int>?, maxSoFar: Int = root?.`val` ?: 0): Int {
    return root?.let {
        var result = countAndCheck(root.left, max(it.`val`, maxSoFar)) +
                countAndCheck(root.right, max(it.`val`, maxSoFar))
        if (it.`val` >= maxSoFar) result ++
        result
    } ?: 0
}




fun goodNodesIterative(root: TreeNode<Int>?): Int {
    var result = 0
    val stack = Stack<Pair<TreeNode<Int>?, Int>> ()
    stack.push(Pair(root, Int.MIN_VALUE))
    while (stack.isNotEmpty()) {
        val pair = stack.pop()
        val node = pair.first
        val maxSoFar = pair.second
        node?.let { if(it.`val` >= maxSoFar) result++ }
        node?.left?.let { stack.push(Pair(it, max(maxSoFar, it.`val`))) }
        node?.right?.let { stack.push(Pair(it, max(maxSoFar, it.`val`))) }
    }
    return result
}

