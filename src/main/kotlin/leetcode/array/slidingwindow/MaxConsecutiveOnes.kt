//https://tinyurl.com/leetcode036
package leetcode.array.slidingwindow

import kotlin.math.max

fun main() {
    var size = (10..15).random()
    val nums = generateSequence {
        (size--).takeIf {
            it > 0
        }
    }.toList().map { it % 2 }.shuffled()
    println(nums.joinToString("\t"))
    println(longestOnes(nums.toIntArray(), (2..nums.size - 8).random()))
}

private fun longestOnes(nums: IntArray, k: Int): Int {
    if(k >= nums.size) return nums.size
    var left = 0
    var zeroCount = 0
    var longest = 0
    for (right in nums.indices){
        if(nums[right] == 0) zeroCount++
        if(zeroCount > k) {
            if(nums[left] == 0) zeroCount--
            left++
        }
        longest = max(longest, right - left + 1)
    }
    return longest
}