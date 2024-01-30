//http://tinyurl.com/leetcode075
package leetcode.stack

import java.util.Stack
import kotlin.math.abs


fun main() {
    var size = (1..10).random()
    val asteroids = generateSequence {
        size--
        (-10..10).random().takeIf {
            size > 0
        }
    }.toList().shuffled()
    println(asteroids)
    println(asteroidCollision(asteroids.toIntArray()).joinToString(", "))
}

fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack = Stack<Int>()
    for (asteroid in asteroids) {
        while (stack.isNotEmpty() && stack.peek() > 0 &&  asteroid < 0 && abs(stack.peek()) < abs(asteroid)) {
            stack.pop()
        }
        if (stack.isEmpty() || stack.peek() < 0 || (stack.peek() > 0  && stack.peek() * asteroid > 0)) {
            stack.push(asteroid)
            continue
        }
        if(stack.isNotEmpty() && stack.peek() > 0  && stack.peek() == asteroid * -1) {
            stack.pop()
            continue
        }
    }
    return stack.toIntArray()
}