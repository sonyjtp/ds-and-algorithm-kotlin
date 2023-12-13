//https://tinyurl.com/leetcode038
package leetcode.array.prefixsum

fun main() {
//    val nums = (-8..5).toList().shuffled().take(5)
    val nums= listOf(1,-2,-3)
    println(nums)
    println(minStartValue(nums.toIntArray()))
}



fun minStartValue(nums: IntArray): Int {
    var minStartValue = if (nums[0] < 1) 1 - nums[0] else 1
    var sum = 1
    for(i in 1..<nums.size){
        sum+= nums[i]
        if(sum < 1) {
            minStartValue += 1 - sum
            sum = 1
        }
    }
    return minStartValue
}