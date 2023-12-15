//https://tinyurl.com/leetcode034
package leetcode.array.map

fun main() {
//    val nums = (-5..10).shuffled().take(8).toIntArray()
//    val target = (5..15).random()
    val nums = intArrayOf(2,7,11,15)
    val target = 9
    println(target)
    println(twoSum(nums, target).joinToString(" "))
}
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int,Int>()
    for(i in nums.indices){
        val num = target - nums[i]
        map[nums[i]]?.let {
            return intArrayOf(it, i)
        } ?: run {
            map[num] = i
        }
    }
    return intArrayOf()
}