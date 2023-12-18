// https://tinyurl.com/leetcode049
package leetcode.array.map

import kotlin.math.max

fun main() {
    var size = 20
    val nums = generateSequence {
        size --
        (1..10).random().takeIf {
           size >0
        }
    }.toList()
    println(nums)
    println(largestUniqueNumber(nums.toIntArray()))
    println(largestUniqueNumber2(nums.toIntArray()))
}


fun largestUniqueNumber(nums: IntArray): Int {
    val numMap = mutableMapOf<Int, Int>()
    var maxUnique = -1
    nums.forEach { numMap[it] = numMap.getOrDefault(it, 0) + 1  }
    numMap.filterValues { it == 1 }.keys.forEach { maxUnique = max(maxUnique, it) }
    return maxUnique
}


fun largestUniqueNumber2(nums: IntArray): Int {
    val numMap = mutableMapOf<Int, Int>()
    for(num in nums) {
        numMap[num] = numMap.getOrDefault(num, 0) + 1
    }
    return numMap.filter {(_, value) -> value == 1}.keys.let {
        if (it.isEmpty()) -1 else it.max()
    }
}

