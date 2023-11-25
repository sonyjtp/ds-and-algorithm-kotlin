//https://tinyurl.com/leetcode033
package leetcode.array

import kotlin.math.max

fun main() {
    val nums = (-10..20).shuffled().take(8).toIntArray()
    val k = (3..5).random()
    println(nums.joinToString(","))
    println(k)
    println(findMaxAverage(nums, k))
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var right = 0
    var maxAvg = Double.MAX_VALUE * -1
    var sum = 0.00000
    for(left in 0 .. nums.size - k) {
        if (left == 0){
            while (right < k){
                sum+= nums[right]
                right++
            }
        } else sum = sum + nums[left + k - 1] - nums[left - 1]

        maxAvg = max(sum / k, maxAvg)
    }
    return maxAvg
}


