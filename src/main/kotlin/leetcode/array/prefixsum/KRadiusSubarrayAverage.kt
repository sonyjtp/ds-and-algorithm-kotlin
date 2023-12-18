//https://tinyurl.com/leetcode054
package leetcode.array.prefixsum

fun main() {
    val count = (5..10).random()
    val nums = (1..20).shuffled().take(count)
//    val nums = listOf(3, -9, -4, 7, -6, 9, 10, -10)
    val k =(1..<count/2).random()
//    val k = 2
    println(nums)
    println(k)
    println(getAverages(nums.toIntArray(), k).toList().joinToString())
}



fun getAverages(nums:IntArray, k: Int): IntArray {
    var sum = 0L
    val kRadiusAvg = IntArray(nums.size)
    val divisor = (k * 2 +1).toLong()
    for(right in nums.indices){
        if(right - k < 0 || right + k >= nums.size){
            kRadiusAvg[right] = -1

        } else if(right==k) {
            var i = 0
            while (i <= right + k) {
                sum+=nums[i]
                i++
            }
            kRadiusAvg[right]= (sum /divisor).toInt()
        }
        else {
            sum-= nums[right - k - 1]
            sum+= nums[right + k]
            kRadiusAvg[right]= (sum /divisor).toInt()
        }
    }
    return kRadiusAvg
}
