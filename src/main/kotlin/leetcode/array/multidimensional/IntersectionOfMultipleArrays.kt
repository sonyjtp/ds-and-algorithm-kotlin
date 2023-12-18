//http://tinyurl.com/leetcode045
package leetcode.array.multidimensional

fun main() {
    val arrCount = (2..4).random()
    val nums = Array((arrCount)){ intArrayOf() }
    for(i in 0 until arrCount) {
        val size = (3..5).random()
        nums[i] = (1..10).shuffled().take(size).toIntArray()
    }
    nums.forEach { println(it.toList().joinToString(" ")) }
    println(intersection(nums))
    println(intersection2(nums))
}

fun intersection(nums: Array<IntArray>): List<Int> {
    val n = nums.size
    val result = mutableListOf<Int>()
    val arr = IntArray(1001)
    for (row in nums) for (num in row) arr[num]++
    for (i in arr.indices) if (arr[i] == n) result.add(i)
    return result
}

fun intersection2(nums: Array<IntArray>): List<Int> {
    val allNums = mutableMapOf<Int, Int>()
    val size = nums.size
    for(numArr in nums) {
        for (num in numArr) {
            allNums[num] = allNums.getOrDefault(num, 0) + 1
        }
    }
    return allNums.filter { it.value == size }.map { it.key }.sorted().toList()
}