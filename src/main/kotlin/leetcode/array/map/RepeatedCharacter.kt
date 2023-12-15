// http://tinyurl.com/leetcode042
package leetcode.array.map

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
    val charMap = mutableMapOf<Char, Boolean>()
    for(char in s){
        if (charMap[char] == true) return char else charMap[char] = true
    }
    return ' '
}
