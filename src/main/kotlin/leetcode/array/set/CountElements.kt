//http://tinyurl.com/leetcode045
package leetcode.array.set

fun main() {
    val nums = (1..10).shuffled().take(5) + (1..10).shuffled().take(5)
    println(nums)
    println(countElements(nums.toIntArray()))

}

fun countElements(arr: IntArray): Int {
    var count = 0
    val elementSet = mutableSetOf<Int>()
    arr.forEach(elementSet::add)
    for(i in arr.indices) { if (arr[i] + 1 in elementSet) count++ }
    return count
}