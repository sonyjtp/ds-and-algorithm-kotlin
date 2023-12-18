//https://tinyurl.com/leetcode055
package leetcode.array.slidingwindow

import kotlin.math.max

fun main() {
    val binary = listOf(0,1)
    var count = (2..10).random()
    val nums = generateSequence {
        count--
        binary.random().takeIf { count >=0 }
    }.toList()
    println(nums)
    println(findMaxLength(nums.toIntArray()))
}

fun findMaxLength(nums: IntArray): Int {
    var maxLength = 0
    var counter = 0
    val countMap = mutableMapOf(0 to -1)
    for(i in nums.indices) {
        if(nums[i] == 1) counter++ else counter--
        countMap[counter]?.let { value ->
            maxLength = max(maxLength, i - value)
        } ?: run {  countMap[counter] = i }
    }
    return maxLength
}

/*
0, 1, 0, 0, 1, 0, 1

countMap
-1  0,
0   -1 ,
-1  maxLen=2
-2  3
-1  maxLen=4
-2  2
-1  maxLen = 6

0,0,0,0,0,1,1,1,1,0,1,1
0   -1
-1  0
-2  1
-3  2
-4  3
-5  4
-4  maxlen = 2
-3  maxLen = 4
-2  maxLen = 6
-1  maxLen = 8
-2  maxLen = 8
-1  maxLen = 10
0   maxLen = 12
 */