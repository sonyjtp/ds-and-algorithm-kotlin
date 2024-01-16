//http://tinyurl.com/leetcode060
package leetcode.stack

import java.util.Stack


private val BRACKET_PAIRS = mapOf(
    '(' to ')',
    '{' to '}',
    '[' to ']'
)
fun main() {
    println(isValid("(){}[]"))
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for(c in s.toCharArray()) {
        BRACKET_PAIRS[c]?.let {
            stack.push(c)
        } ?: run {
            if(stack.isEmpty()) return false
            val prev = stack.pop()
            if (BRACKET_PAIRS[prev] != c) return false
        }
    }
    return stack.isEmpty()
}