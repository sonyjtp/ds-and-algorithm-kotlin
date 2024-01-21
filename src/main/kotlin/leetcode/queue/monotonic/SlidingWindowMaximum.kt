// http://tinyurl.com/leetcode068
package leetcode.queue.monotonic


fun main() {
    val windowSize = (3..8).random()
    var arraySize =  (windowSize + 1..windowSize+5).random()
    val nums = generateSequence {
        arraySize --
        (-5..10).random().takeIf {
            arraySize > 0
        }

    }.shuffled().toList()
    println(nums)
    println(windowSize)
    println(maxSlidingWindow(nums.toIntArray(), windowSize).toList())


}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val maxDeque = ArrayDeque<Int>()
    var left = 0
    val result = IntArray(nums.size - k + 1)
    for (right in nums.indices) {
        while (maxDeque.isNotEmpty() && nums[maxDeque.last()] < nums[right]) {
            maxDeque.removeLast()
        }
        maxDeque.addLast(right)
        if (right - left == k - 1) {
            result[left] = nums[maxDeque.first()]
            if (nums[maxDeque.first()] == nums[left]) { maxDeque.removeFirst() }
            left++
        }
    }
    return result
}
