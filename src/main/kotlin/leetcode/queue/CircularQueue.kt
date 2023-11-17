// https://tinyurl.com/leetcode029
package leetcode.queue



class  CircularQueue<E>(val size: Int) {
    private val data = mutableListOf<E>()
    private var headIdx: Int = 0

    fun head() = data[headIdx]

    fun tail() = data[data.size - 1]

    fun enqueue(element: E) = data.add(element)

    fun dequeue(): Boolean {
        if (isEmpty()) return false
        headIdx ++
        return true
    }

    fun isEmpty() = headIdx >= data.size

    fun  isFull() =  size == data.size
}
