package leetcode.stack.monotonic

import java.util.Stack


fun main() {
    var size = (5..10).random()

    val nums = generateSequence {
        size--
        (30..50).random().takeIf {
            size > 0
        }
    }.toList().shuffled()
    println(nums)
    println(dailyTemperatures(nums.toIntArray()).joinToString(", "))
}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stack = Stack<Int>()
    val result = IntArray(temperatures.size)
    for(i in temperatures.indices) {
        while(stack.isNotEmpty() && temperatures[stack.peek()] < temperatures[i]) {
            val j = stack.pop()
            result[j] = i - j
        }
        stack.push(i)
    }
    return result
}

