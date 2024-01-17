//http://tinyurl.com/leetcode064
package leetcode.stack

import java.util.Stack
import kotlin.math.abs


fun main() {
    for(s in listOf("leEeetcode", "abBAcC", "s")) {
        println(makeGood(s))
    }
}

fun makeGood(s: String): String {
    return Stack<Char>().apply {
        for(chr in s) {
            if(isNotEmpty() && abs(chr - peek()) == 32) pop() else push(chr)
        }
    }.joinToString("")
}
