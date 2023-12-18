// https://tinyurl.com/leetcode050
package leetcode.array.map


fun main() {
    val chars = listOf('b', 'a', 'l', 'o', 'n', 'k', 'e')
    var size = 20
    val text = generateSequence {
        size--
        chars.random().takeIf {
            size > 0
        }
    }.joinToString("")
    println(text)
    println(maxNumberOfBalloons(text))
}

fun maxNumberOfBalloons(text: String): Int {
    val balloonMap = mutableMapOf('b' to 0, 'a' to 0, 'l' to 0, 'o' to 0, 'n' to 0)
    for(chr in text) {
        balloonMap[chr]?.let {  balloonMap[chr] = balloonMap[chr]!! + 1 }
    }
    balloonMap['l'] = balloonMap['l']!! / 2
    balloonMap['o'] = balloonMap['o']!! / 2
    return balloonMap.minBy {
        it.value
    }.value
}


