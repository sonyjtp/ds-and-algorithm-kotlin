//https://tinyurl.com/leetcode023
package leetcode.tree.bfs

import leetcode.tree.pojo.TreeNode
import java.util.*

/** doesn't work - memory limit exceeded */
fun zigzagLevelOrderBfs(root: TreeNode<Int>?): List<List<Int>> {
    root ?: return listOf()
    val result = mutableListOf<List<Int>>()
    val nodes = LinkedList<TreeNode<Int>>()
    var nodesInSameLevel = LinkedList<Int>()
    var fromLeft = true
    nodes.addLast(root)
    nodes.addLast(null)
    while (nodes.isNotEmpty()) {
        nodes.pollFirst()?.let { currNode ->
            if (fromLeft) nodesInSameLevel.addLast(currNode.`val`) else nodesInSameLevel.addFirst(currNode.`val`)
            currNode.left?.let { nodes.addLast(it) }
            currNode.right?.let { nodes.addLast(it) }
        } ?: run {
            result.add(nodesInSameLevel)
            nodesInSameLevel = LinkedList<Int>()
            if (nodes.isNotEmpty()) nodes.addLast(null)
            fromLeft = !fromLeft
        }
    }
    return result
}
