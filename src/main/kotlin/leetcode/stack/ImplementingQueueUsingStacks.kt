//http://tinyurl.com/leetcode072
package leetcode.stack

import java.util.*


class MyQueue() {
    private val pushStack = Stack<Int>()
    private val popStack = Stack<Int> ()

    fun push(x: Int) {
        pushStack.push(x)

    }

    fun pop() = peek().also { return popStack.pop() }



    fun peek(): Int {
        if(popStack.isEmpty()) {
            while ((pushStack.isNotEmpty())) {
                popStack.add(pushStack.pop())
            }
        }
        return popStack.peek()
    }

    fun empty() = pushStack.isEmpty() && popStack.isEmpty()
}



/**
 * 1,2,3,4, 5
 * front - 1, 2
 * back - 2
 */