//https://tinyurl.com/leetcode039
package leetcode.array.slidingwindow

import kotlin.math.min


fun main() {
//    val nums = (1..15).toList().shuffled().take(8)
    val nums = listOf(6, 7, 13, 4, 8, 1, 15, 14)
    val target = 10
//    val target = (10..25).random()
    println(nums)
    println(target)
    minSubArrayLen(target, nums.toIntArray())
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    if(nums.sum() < target) return 0
    var minSubArrayLen = nums.size
    var (left, right) = Pair(0,0)
    var sum =0
    while (right in nums.indices){
        sum += nums[right]
        if(sum >= target){
            minSubArrayLen = min(minSubArrayLen, right - left + 1)
        } else {
            while (sum < target && right < nums.size) {
                right++
                sum += nums[right]
            }
            if(sum >=target && right < nums.size) {
                minSubArrayLen = min(minSubArrayLen, right - left + 1)
            }
        }
        while (sum >= target && left < right) {
            left++
            sum -= left
        }
        minSubArrayLen = min(minSubArrayLen, right - left + 1)

    }

    return minSubArrayLen
}



