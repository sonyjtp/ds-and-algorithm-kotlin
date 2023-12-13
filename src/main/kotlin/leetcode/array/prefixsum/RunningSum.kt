package leetcode.array.prefixsum

fun main() {
    val nums = (-10..10).toList().shuffled().take(8)
    println(nums)
    println(runningSum(nums.toIntArray()).joinToString(", "))
}

private fun runningSum(nums: IntArray): IntArray {
    val runningSum = IntArray(nums.size)
    for(i in nums.indices) {
        if(i != 0) runningSum[i] = runningSum[i - 1] + nums[i]
        else runningSum[i] = nums[i]
    }
    return runningSum
}