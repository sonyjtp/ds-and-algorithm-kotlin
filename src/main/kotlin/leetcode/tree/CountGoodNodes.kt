//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
package leetcode.tree

import leetcode.tree.pojo.TreeNode
import java.util.Stack
import kotlin.math.max


private var count = 1

fun goodNodes(root:TreeNode<Int>?): Int {
    if (root == null) return 0
    root.left?.let {
        if (it.`val` >= root.`val`) count++ else it.`val` = root.`val`
        goodNodes(it)
    }?:0
    root.right?.let {
        if (it.`val` >= root.`val`) count++ else it.`val` = root.`val`
        goodNodes(it)
    }?: 0
    return count
}

fun goodNodes2(root: TreeNode<Int>?, maxSoFar: Int): Int {
    if (root == null) return 0
    val left = goodNodes2(root.left, max(maxSoFar, root.`val`))
    val right = goodNodes2(root.right, max(maxSoFar, root.`val`))
    var result = left + right
    if (root.`val` > maxSoFar) result++
    return result
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

