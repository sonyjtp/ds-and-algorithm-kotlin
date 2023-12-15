//https://tinyurl.com/leetcode033
package leetcode.array.prefixsum

import kotlin.math.max

fun main() {
    val nums = (-10..20).shuffled().take(8).toIntArray()
    val k = (3..5).random()
    println(nums.joinToString(","))
    println(k)
    println(findMaxAverage(nums, k))
    println(findMaxAverage2(nums, k))
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


fun findMaxAverage2(nums: IntArray, k: Int): Double {
    var sum = 0.0
    for(i in 0 until  k) {
        sum += nums[i]
    }
    var maxSum = sum
    for ((left, i) in (k until  nums.size).withIndex()){
        sum += nums[i] - nums[left]
        maxSum = max(maxSum, sum)
    }
    return maxSum / k
}

