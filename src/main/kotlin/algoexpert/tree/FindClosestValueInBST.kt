//https://www.algoexpert.io/questions/find-closest-value-in-bst
package algoexpert.tree

import kotlin.math.abs



open class BST(var value: Int) {
    var left: BST? = null
    var right: BST? = null
}

fun findClosestValueInBst(tree: BST, target: Int): Int {
    val left = tree.left
    var right = tree.right

    return tree.value
}
