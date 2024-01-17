//http://tinyurl.com/leetcode065
package leetcode.queue


private val counterQueue = CounterQueue()

fun main() {
    for (t in listOf(1, 100, 3000, 3001, 3002)) {
        println(ping(t))
    }
}

fun ping(t: Int): Int {
    while (!counterQueue.isEmpty() && counterQueue.peek() < t - 3000) counterQueue.poll()
    counterQueue.offer(t)
    return counterQueue.size()
}


private class CounterQueue {
    private var headIdx: Int = 0
    private var data = mutableListOf<Int>()

    fun offer(int: Int) { data.add(int) }

    fun peek() = data[headIdx]

    fun poll() = if (isEmpty()) null else { data[headIdx].also { headIdx++ } }

    fun isEmpty() = headIdx >= data.size

    fun size() = data.size - headIdx
}
