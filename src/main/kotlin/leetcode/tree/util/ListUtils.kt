package leetcode.tree.util

import leetcode.tree.pojo.TreeNode

fun buildTree(nodes: List<Int?>, i: Int = 0): TreeNode<Int>? {
    if (i < nodes.size) {
        return nodes[i]?.let {
            val next =  TreeNode(it)
            next.left = buildTree(nodes, 2 * i + 1)
            next.right = buildTree(nodes, 2 * i + 2)
            next
        }
    }
    return null
}

fun main()  = println(buildTree(listOf(1,2,3, 4, null, null, 5)))
