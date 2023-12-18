//https://tinyurl.com/leetcode048
package leetcode.array.multidimensional


fun main() {
    val matches = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(3, 6),
        intArrayOf(5, 6),
        intArrayOf(5, 7),
        intArrayOf(4, 5),
        intArrayOf(4, 8),
        intArrayOf(4, 9),
        intArrayOf(10, 4),
        intArrayOf(10, 9)
    )
    println(findWinners(matches))
}

fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val lossCountMap = mutableMapOf<Int, Int>()
    for(match in matches) {
        val winner = match[0]
        val loser = match[1]
        lossCountMap[winner] = lossCountMap.getOrDefault(winner, 0)
        lossCountMap[loser] = lossCountMap.getOrDefault(loser, 0) + 1
    }
    return listOf(
        lossCountMap.filter { (_, value) -> value == 0 }.map { it.key }.sorted(),
        lossCountMap.filter { (_, value) -> value == 1 }.map { it.key }.sorted()
    )
}
