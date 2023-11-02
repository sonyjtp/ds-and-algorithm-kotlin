// https://www.algoexpert.io/questions/branch-sums
package algoexpert.tree

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun branchSums(root: BinaryTree?): List<Int> {
    if (root == null) return emptyList()
    if (root.left == null && root.right == null) return listOf(root.value)
    return (branchSums(root.left) + branchSums(root.right)).map {
        it + root.value
    }


}
