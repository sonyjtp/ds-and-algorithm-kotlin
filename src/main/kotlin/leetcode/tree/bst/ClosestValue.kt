//https://tinyurl.com/leetcode027
package leetcode.tree.bst

import leetcode.tree.pojo.TreeNode
import kotlin.math.abs

fun closestValue(root: TreeNode<Int>?, target: Double): Int {
    root?: return 0
    var closest = root.`val`
    fun dfs(root: TreeNode<Int>?) {
        root?: return
        val diff = abs(root.`val` - target)
        if (diff < abs(closest - target) || diff == abs(closest - target) && root.`val` < closest)
            closest = root.`val`
        dfs(root.left)
        dfs(root.right)
    }
    dfs(root)
    return closest
}
