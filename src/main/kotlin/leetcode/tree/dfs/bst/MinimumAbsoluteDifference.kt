// https://tinyurl.com/leetcode025
package leetcode.tree.dfs.bst

import leetcode.tree.pojo.TreeNode


fun getMinimumDifference(root: TreeNode<Int>?): Int {
    var diff = Int.MAX_VALUE
    val arr = mutableListOf<Int>()
    fun dfs(root: TreeNode<Int>?) {
        root ?: return
        dfs(root.left)
        arr.add(root.`val`)
        dfs(root.right)
    }
    dfs(root)
    for(i in arr.size -1 downTo 1){
        if (arr[i] - arr[i-1] < diff)  diff = arr[i] - arr[i-1]
    }
    return diff
}
