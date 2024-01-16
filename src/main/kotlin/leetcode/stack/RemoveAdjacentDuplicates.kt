//http://tinyurl.com/leetcode061
package leetcode.stack

import java.util.Stack


fun main() {
    val charRange = ('a'..'e')
    var size = (5..10).random()
    val s = generateSequence {
        size--
        charRange.random().takeIf {
            size > 0
        }
    }.joinToString("")
    println(s)
    println(removeDuplicates("aababaab"))
}

fun removeDuplicates(s: String): String {
    val chars = Stack<Char>()
    for(c in s.toCharArray()) {
        if (chars.isNotEmpty() && chars.peek() == c){
            chars.pop()
        } else chars.push(c)
    }
    return chars.joinToString("")
}