// http://tinyurl.com/leetcode070
package leetcode.stack.monotonic

import java.util.Stack

private val decStack = Stack<Pair<Int, Int>>()
fun main() {
    val stockSpanner = StockSpanner()
    var size = (5..10).random()
    val prices = generateSequence {
        size--
        (1..10).random().takeIf {
            size >0
        }
    }.shuffled().toList()
    println(prices)
    for(price in prices) {
        println(stockSpanner.next(price))
    }
}
class StockSpanner {
    fun next(price: Int): Int {
        var count = 1
        while (decStack.isNotEmpty() && decStack.peek().first <= price) {
            count += decStack.pop().second
        }
        decStack.push(Pair(price, count))
        return count
    }
}
