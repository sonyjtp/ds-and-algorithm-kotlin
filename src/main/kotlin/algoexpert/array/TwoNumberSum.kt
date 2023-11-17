// https://www.algoexpert.io/questions/two-number-sum
package algoexpert.array

fun main() {
    val array = (-5..5).shuffled().take(5).also { println(it.joinToString(" ")) }
    val targetSum = (5..15).random().also(::println)
    println(twoNumberSum(array.toMutableList(), targetSum).joinToString(" "))
}

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    val seen = mutableListOf<Int>()
    for(i in array.indices){
        if (targetSum - array[i] in seen) return  listOf(array[i], targetSum - array[i])
        seen.add(array[i])
    }
    println("not found")
    return listOf()
}


