//https://tinyurl.com/leetcode032
//sliding window
package leetcode.array.slidingwindow

fun main() {

    val nums = (1..20).shuffled().take(8).toIntArray()
    val k = (40..100).random()
    println(k)
    println(numSubarrayProductLessThanK(nums, k))
}

fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    println(nums.joinToString(" "))
    var result = 0
    var left = 0
    var product = 1
    for(right in nums.indices) {
        product *= nums[right]
        while (product >= k && left <= right) {
            product /= nums[left]
            left++
        }
        result += right - left + 1
    }
    return result
}

