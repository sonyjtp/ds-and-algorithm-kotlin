package leetcode.queue

class Queue<E> {
    private val data = mutableListOf<E>()
    private var headIdx: Int = 0

    fun head() = data[headIdx]

    fun enqueue(element: E) = data.add(element)

    fun dequeue(): Boolean {
        if (isEmpty()) return false
        headIdx ++
        return true
    }

    fun isEmpty() = headIdx >= data.size
}
