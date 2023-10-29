// https://www.algoexpert.io/questions/validate-subsequence
package algoexpert.array

fun main() {
    val array = (-5..5).shuffled().take(8)
    val sequence = (-3.. 2).shuffled().take(2)
    println(array)
    println(sequence)
    println("Is subsequence: ${isValidSubsequence(array, sequence)}")
}


fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var index = 0
    for (i in array.indices) {
        if (array[i] == sequence[index]) index ++
        if (index == sequence.size) return true
    }
    return false
}
