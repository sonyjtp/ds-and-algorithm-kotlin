// http://tinyurl.com/leetcode042
package leetcode.array.set

fun main() {
    val charRange = ('a'..'z')
    var size = (10..50).random()
    val s = generateSequence {
        size--
        charRange.random().takeIf {
            size > 0
        }
    }.joinToString("")
    println(s)
    println(repeatedCharacter(s))
}


fun repeatedCharacter(s: String): Char {
    val charSet = mutableSetOf<Char>()
    for(char in s){ if (char in charSet) return char else charSet.add(char) }
    return ' '
}
