//https://tinyurl.com/leetcode031
package leetcode.array


fun main() {
    val nums = (-2..5).take(7).sorted().toIntArray()
    nums.forEach(::print)
    println()
    sortedSquares(nums).forEach(::print)
}


fun sortedSquares(nums: IntArray): IntArray {
    var (left, right) = Pair(0, nums.size -1)
    val result = IntArray(nums.size)
    var i = 0
    while(left < right && i < nums.size){
        val lSq = nums[left] * nums[left]
        val rSq = nums[right] * nums[right]
        if (lSq > rSq) {
            result[nums.size - i - 1] = lSq
            left++
        } else {
            result[nums.size -i - 1] = rSq
            right--
        }
        i++
    }
    return result
}