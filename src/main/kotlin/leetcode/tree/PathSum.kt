//https://leetcode.com/problems/path-sum/

package leetcode.tree

import leetcode.tree.pojo.TreeNode
import java.util.Stack


// using post-order traversal and recursion
fun hasPathSum(root: TreeNode<Int>?, targetSum: Int): Boolean {
    if(root == null) return false
    val left = root.left
    val right = root.right
    if(left == null && right == null) return  root.`val` == targetSum
    val leftSum = left?.let { currLeft ->
        currLeft.`val` += root.`val`
        hasPathSum(currLeft, targetSum)
    }?: false
    val rightSum = right?.let { currRight ->
        currRight.`val` += root.`val`
        hasPathSum(currRight, targetSum)
    }?: false
    return leftSum || rightSum
}


// using pre-order traversal and stack
fun hasPathSumPreOrder(root: TreeNode<Int>?, targetSum: Int): Boolean {
    if(root == null) return false
    val stack = Stack<Pair<TreeNode<Int>,Int>>()
    stack.push(Pair(root, root.`val`))
    while (stack.isNotEmpty()){
        val pair = stack.pop()
        val left = pair.first.left
        val right = pair.first.right
        if(left == null && right == null && pair.second == targetSum) return true
        left?.let { currLeft -> stack.push(Pair(currLeft, pair.second + currLeft.`val`)) }
        right?.let { currRight -> stack.push(Pair(currRight, pair.second + currRight.`val`)) }
    }
    return false
}

