package leetcode.tree

import leetcode.tree.pojo.TreeNode

object BinaryTreeSearch {

    fun <T> depthFirstSearch(node: TreeNode<T>?) {
        if(node == null) return
        depthFirstSearch(node.left)
        depthFirstSearch(node.right)
    }

    // execute the logic before traversal
    fun <T>preOrderDfs(node: TreeNode<T>?) {
        if(node == null) return
        println(node.`val`)
        preOrderDfs(node.left)
        preOrderDfs(node.right)

    }

    fun <T> inOrderDfs(node: TreeNode<T>?) {
        if (node == null) return
        inOrderDfs(node.left)
        println(node.`val`)
        inOrderDfs(node.right)
    }

    fun <T> postOrderDfs(node: TreeNode<T>?) {
        if (node == null) return
        postOrderDfs(node.left)
        postOrderDfs(node.right)
        println(node.`val`)
    }

}
