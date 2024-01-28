// http://tinyurl.com/leetcode074
package leetcode.stack

import java.util.*

fun main() {
    val pushed = intArrayOf(1,2,3,4,5)
    println(validateStackSequences(pushed, intArrayOf(4,5,3,2,1)))
    println(validateStackSequences(pushed, intArrayOf(4,3,5,1,2)))
    println(validateStackSequences(pushed, intArrayOf(1,4,3,5,2)))
}

fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
    val stack = Stack<Int>()
    val n = pushed.size
    var j = 0
    for(i in pushed) {
        stack.push(i)
        while (stack.isNotEmpty() && j < n && stack.peek() == popped[j]){
            stack.pop()
            j++
        }
    }
    return j == n
}

/**
 * 12345
 * 12345    14352
 * */