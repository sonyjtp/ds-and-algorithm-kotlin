// https://tinyurl.com/leetcode020
package leetcode.tree

import leetcode.tree.pojo.TreeNode
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


fun maxAncestorDiff(root: TreeNode<Int>?, min: Int = -1, max: Int = -1): Int {
    if (root== null || (root.left == null && root.right == null)) return max - min
    val minVal = if (min == -1)  root.`val` else min(root.`val`, min)
    val maxVal = if(max == -1) root.`val` else max(root.`val`, max)
    val left = root.left
    val right = root.right
    if (left == null) return maxAncestorDiff(right,min(minVal, right!!.`val`), max(maxVal, right.`val`))
    if (right == null) return maxAncestorDiff(left,min(minVal, left.`val`),max(maxVal, left.`val`))
    return abs(
        max(
            maxAncestorDiff(right,min(minVal, right.`val`), max(maxVal, right.`val`)),
            maxAncestorDiff(left,min(minVal, left.`val`),max(maxVal, left.`val`))
        )
    )
}

