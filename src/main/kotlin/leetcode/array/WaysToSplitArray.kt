//https://tinyurl.com/leetcode035
package leetcode.array

//The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
//There is at least one element to the right of i. That is, 0 <= i < n - 1.
fun main() {
 val nums = (-8..8).toList().shuffled().take(8)
    println(nums.joinToString(", "))
    println(waysToSplitArray(nums.toIntArray()))
}

fun waysToSplitArray(nums: IntArray): Int {
    var validSplits = 0
    var sumLeft: Long = 0
    var sumRight: Long = 0
    for (i in nums.indices) {
        sumRight += nums[i]
    }
    for (i in 0 until nums.size -1) {
        sumLeft += nums[i]
        sumRight -= nums[i]
        println("sumLeft: $sumLeft, sumRight:: $sumRight")
        if(sumLeft >= sumRight) validSplits++
    }
    return validSplits
}