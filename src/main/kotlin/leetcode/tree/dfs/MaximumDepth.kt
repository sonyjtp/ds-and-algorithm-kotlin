//https://leetcode.com/problems/maximum-depth-of-binary-tree/
package leetcode.tree.dfs

import leetcode.tree.pojo.TreeNode
import java.util.Stack
import kotlin.math.max

// using post-order traversal and recursion
fun <T> maxDepth(root: TreeNode<T>?): Int {
        return if (root == null) 0 else  max(maxDepth(root.left), maxDepth(root.right)) + 1
}


// using pre-order traversal and stack
fun <T> maxDepthPreOrderTraversal(root: TreeNode<T>?): Int {
        if(root== null) return 0
        var maxDepth = 0
        val stack =  Stack<Pair<TreeNode<T>, Int>>()
        stack.push(Pair(root, 1))
        while (stack.isNotEmpty()) {
                val pair = stack.pop()
                val treeNode = pair.first
                val depth = pair.second
                maxDepth = max(maxDepth, depth)
                treeNode.left?.let { leftNode -> stack.push(Pair(leftNode, depth + 1)) }
                treeNode.right?.let { rightNode -> stack.push(Pair(rightNode, depth + 1)) }
        }
        return maxDepth

}

