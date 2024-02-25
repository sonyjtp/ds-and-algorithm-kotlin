//https://leetcode.com/problems/path-sum/

package leetcode.tree.dfs

import leetcode.tree.pojo.TreeNode
import java.util.Stack


// using post-order traversal and recursion
fun hasPathSum(root: TreeNode<Int>?, targetSum: Int) = sumNodes(root, targetSum, 0)

fun sumNodes(root: TreeNode<Int>?, targetSum: Int, sum: Int): Boolean {
    return root?.let {
        val iterSum = sum + root.`val`
        if(it.left == null && it.right == null) return targetSum == iterSum
        return sumNodes(it.left, targetSum, iterSum) ||
                sumNodes(it.right, targetSum, iterSum)
    } ?: false
}


// using pre-order traversal and stack
fun hasPathSumPreOrder(root: TreeNode<Int>?, targetSum: Int): Boolean {
    root?.let {
        val stack = Stack<Pair<TreeNode<Int>,Int>>() //node, sum
        stack.push(Pair(root, root.`val`))
        while (stack.isNotEmpty()){
            val pair = stack.pop()
            val left = pair.first.left
            val right = pair.first.right
            if(left == null && right == null) return pair.second == targetSum
            left?.let { l -> stack.push(Pair(l, pair.second + l.`val`)) }
            right?.let { r -> stack.push(Pair(r, pair.second + r.`val`)) }
        }
    }
    return false
}

