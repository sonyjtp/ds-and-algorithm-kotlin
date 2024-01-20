//http://tinyurl.com/leetcode066
package leetcode.queue

class MovingAverage(private val size: Int) {
    private val data = mutableListOf<Int>()
    private var headIdx = 0
    private var sum = 0.0

    private fun offer(`val`: Int) {
        if (data.isNotEmpty() && data.size >= size) poll()
        data.add(`val`)
        sum += `val`
    }

    private fun poll(): Int? {
        return if (data.isEmpty()) null else {
            data[headIdx]
        }.also {
            sum -= data[headIdx]
            headIdx++
        }
    }

    private fun size() = data.size - headIdx

    fun next(`val`: Int): Double {
        offer(`val`)
        return sum / size()
    }
}

fun main() {
    val movingAverage = MovingAverage(3)
    for(i in listOf(1,10,3, 5)) {
        println(movingAverage.next(i))
    }
}