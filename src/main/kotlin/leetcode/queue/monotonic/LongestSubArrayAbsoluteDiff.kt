// http://tinyurl.com/leetcode067
package leetcode.queue.monotonic

import kotlin.math.max

fun main() {
    var size = (5..10).random()
    val nums = generateSequence {
        size--
        (1..20).random().takeIf {
            size > 0
        }
    }.shuffled().toList()
    println(nums)
    println(longestSubarray(nums.toIntArray(), (5..10).random()))
}

fun longestSubarray(nums: IntArray, limit: Int): Int {
    val incStack = ArrayDeque<Int>(nums.size)
    val decStack = ArrayDeque<Int>()
    var result = 0
    var left = 0
    for(right in nums.indices){
        while (incStack.isNotEmpty() && incStack.last() > nums[right]) {
            incStack.removeLast()
        }
        incStack.addLast(nums[right])
        while (decStack.isNotEmpty() && decStack.last() < nums[right]) {
            decStack.removeLast()
        }
        decStack.addLast(nums[right])
        while (decStack.first() - incStack.first() > limit) {
            if (nums[left] == incStack.first()) incStack.removeFirst()
            if (nums[left] == decStack.first()) decStack.removeFirst()
            left++
        }
        result = max(result, right - left + 1)
    }
    return result
}




/*
* 8,2,4,7
*
* */