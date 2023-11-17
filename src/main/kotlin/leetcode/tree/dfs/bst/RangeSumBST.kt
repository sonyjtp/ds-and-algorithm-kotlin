//https://tinyurl.com/leetcode024
package leetcode.tree.dfs.bst

import leetcode.tree.pojo.TreeNode


fun rangeSumBST(root: TreeNode<Int>?, low: Int, high: Int): Int {
    var sum = 0
    fun bst(root: TreeNode<Int>?){
        root?: return
        if (root.`val` < low) { bst(root.right) }
        else if (root.`val` > high) { bst(root.left) }
        else {
            sum += root.`val`
            bst(root.left)
            bst(root.right)
        }
    }
    bst(root)
    return sum
}
