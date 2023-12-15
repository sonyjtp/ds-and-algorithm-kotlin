//https://tinyurl.com/leetcode039
package leetcode.array.slidingwindow

import kotlin.math.min


fun main() {
    val nums = (1..15).toList().shuffled().take(8)
//    val nums = listOf(2,3,1,2,4,3)
//    val target = 7
    val target = (10..25).random()
    println(nums)
    println(target)
    println(minSubArrayLen(target, nums.toIntArray()))
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var (left, sum) = Pair(0,0)
    var minSubArrayLen = nums.size + 1
    for(right in nums.indices){
        sum+= nums[right]
        if (sum >= target) {
            minSubArrayLen = min(minSubArrayLen, right - left + 1)
            while (sum >= target && left <= right) {
                minSubArrayLen = min(minSubArrayLen, right - left + 1)
                sum -= nums[left]
                left++
            }
        }
    }
    return if(minSubArrayLen > nums.size) 0 else minSubArrayLen
}
