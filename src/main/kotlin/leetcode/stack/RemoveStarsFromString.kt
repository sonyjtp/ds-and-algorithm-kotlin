//http://tinyurl.com/leetcode071
package leetcode.stack

import java.util.*


fun main() {
    var len = (5..10).random()
    val stars = MutableList((1.. len -3).random()){"*"}
    val s = (generateSequence {
        len--
        ('a'..'z').random().takeIf { len >0 }
    }.toMutableList() + stars).shuffled()
    println(s.joinToString(""))
    println(removeStars(s.joinToString("")))
}

fun removeStars(s: String): String {
    val stack = Stack<Char>()
    for(c in s) {
        if (c != '*'){stack.push(c)}
        else if(stack.isNotEmpty()) {
            stack.pop()
        }
    }
    return stack.joinToString("")
}