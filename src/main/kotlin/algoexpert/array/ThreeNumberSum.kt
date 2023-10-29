//https://www.algoexpert.io/questions/three-number-sum
package algoexpert.array

fun main() {
    val array = mutableListOf(12, 3, 1, 2, -6, 5, -8, 6)
    val targetSum =0
    println(array)
    println(targetSum)
    println(threeNumberSum(array, targetSum))
}


fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    val sorted = array.sorted()
    println(sorted)
    val  found = mutableListOf<List<Int>>()
    for (idx in sorted.indices) {
        var left = idx + 1
        var right = sorted.lastIndex
        while (left < right){
            if (sorted[idx] + sorted[left] + sorted[right] == targetSum) {
                found += listOf(sorted[idx], sorted[left], sorted[right])
                left++
                right--
            }
            else if (sorted[idx] + sorted[left] + sorted[right] < targetSum) left++
            else right--
        }
    }
    return found
}
