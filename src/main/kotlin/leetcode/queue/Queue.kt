package leetcode.queue

class Queue<E> {
    // data could be a doubly-linked-list, two stacks, etc.
    private val data = mutableListOf<E>()
    private var headIdx: Int = 0

    // peek()
    fun head() = data[headIdx]

    // offer()
    fun enqueue(element: E) = data.add(element)

    // just shift the head to the next element
    fun dequeue(): Boolean {
        if (isEmpty()) return false
        headIdx ++
        return true
    }

    private fun isEmpty() = headIdx >= data.size

}
