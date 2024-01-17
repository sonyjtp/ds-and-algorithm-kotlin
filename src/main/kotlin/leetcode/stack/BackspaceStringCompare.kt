//http://tinyurl.com/leetcode062

package leetcode.stack

import java.util.*
import kotlin.math.max

fun main() {
    println(backspaceCompare("y#fo##f", "y#f#o##f"))
}

fun backspaceCompare(s: String, t: String): Boolean {
    val len = max(s.length, t.length)
    val sStack = Stack<Char>()
    val tStack = Stack<Char>()
    for(i in 0..len) {
        if (i < s.length){
            if (s[i] != '#') sStack.push(s[i])
            else if (sStack.isNotEmpty()) sStack.pop()

        }
        if (i < t.length){
            if (t[i] != '#') tStack.push(t[i])
            else if (tStack.isNotEmpty()) tStack.pop()

        }
    }
    return sStack.toString() == tStack.toString()
}