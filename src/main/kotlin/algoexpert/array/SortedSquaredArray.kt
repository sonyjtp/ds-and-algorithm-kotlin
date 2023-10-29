package algoexpert.array


fun main() {
    val array = (-5..9).shuffled().take(5).sorted()
    println(array)
    println(sortedSquaredArray(array))
    println(sortedSquaredArraySimple(array))
}


fun sortedSquaredArray(array: List<Int>): List<Int> {
    val result = generateSequence { 0 }.take(array.size).toMutableList()
    var (left, right) = 0 to array.lastIndex
    var index = array.lastIndex
    while(left <= right){
        val leftSq = array[left] * array[left]
        val rightSq = array[right] * array[right]
        if (leftSq > rightSq) {
            result[index] = leftSq
            left ++
        } else {
            result[index] = rightSq
            right--
        }
        index--
    }
    return result
}

fun sortedSquaredArraySimple(array: List<Int>): List<Int> = array.map { it * it }.sorted()
