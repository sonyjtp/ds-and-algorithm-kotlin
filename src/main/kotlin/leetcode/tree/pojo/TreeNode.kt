package leetcode.tree.pojo

data class TreeNode<T>(
    var `val`: T,
) {
    var left: TreeNode<T>? = null
    var right: TreeNode<T>? = null
}
