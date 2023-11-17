//https://tinyurl.com/leetcode022
// Given the root of a binary tree, return the sum of values of its deepest leaves.

package leetcode.tree.dfs

import leetcode.tree.pojo.TreeNode


fun deepestLeavesSum(root: TreeNode<Int>?): Int {
    var depth = 0
    var sum = 0
    fun dfs(node: TreeNode<Int>?, level: Int) {
        node?: return
        dfs(node.left, level + 1)
        dfs(node.right, level + 1)
        node.`val`.let {
            if (level > depth) {
                sum = it
                depth = level
            } else if (level == depth) sum += it
        }
    }
    dfs(root, 0)
    return sum
}


/** 
1. node?: return
2. dfs(node.left, level + 1)
3. dfs(node.right, level + 1)
4. if (level > depth) {
5.  sum = it
6.  depth = level
7. } else if (level == depth) {
8.  sum += it }
9. return sum


false
	dfs(2, 1)
		false
		dfs(4,2)
			false
			dfs(7,3)
				false
				dfs(null,4)
					true
				dfs(null, 4)
				4 > 0? true
					sum = 7
					depth = 4
			dfs(null,3)
			3 > 4 ? false
			3 == 4? false
		dfs (5,2)
			false
			dfs(null,3)
				true
			dfs(null, 3)
				true
			3  > 4? false
			3 == 4 ? false
	dfs (3,1)
		false
		dfs (null, 2)
			true
		dfs (6, 2)
			false
			dfs (8, 3)
				false
				dfs (null, 4)
					true
				dfs (null, 4)
					true
			4 > 4? false
			4 == 4? true
				sum += 8
				sum = 15
 */

