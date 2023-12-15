//http://tinyurl.com/leetcode044
package leetcode.array.prefixsum


fun main() {
    val nums = (0..10).shuffled().take(10)
    println(nums)
    println(missingNumber(nums.toIntArray()))
}

fun missingNumber(nums: IntArray): Int {
    var sum = 0
    var sumIdx = 0
    for((idx,num) in nums.withIndex()){
        sum += num
        sumIdx +=idx + 1
    }

    return sumIdx - sum
}

