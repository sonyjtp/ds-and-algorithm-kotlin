package leetcode.tree.dfs

import leetcode.tree.pojo.TreeNode

object BinaryTreeSearch {

    private fun <T> depthFirstSearch(node: TreeNode<T>?) {
        node?.let {
            depthFirstSearch(it.left)
            depthFirstSearch(it.right)
        }
        return
    }

    // execute the logic before traversal
    private fun <T>preOrderDfs(node: TreeNode<T>?) {
        node?.let {
            println(it.`val`)
            preOrderDfs(it.left)
            preOrderDfs(it.right)
        }
        return
    }

    // execute the logic after left and before right
    private fun <T> inOrderDfs(node: TreeNode<T>?) {
        node?.let {
            inOrderDfs(it.left)
            println(it.`val`)
            inOrderDfs(it.right)
        }
        return
    }

    // execute the logic after traversal
    private fun <T> postOrderDfs(node: TreeNode<T>?) {
        node?.let {
            postOrderDfs(it.left)
            postOrderDfs(it.right)
            println(it.`val`)
        }
        return
    }
}
