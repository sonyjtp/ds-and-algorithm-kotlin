package leetcode.linkedlist

data class DoublyLinkedListNode(var `val`: Int) {
    var next: DoublyLinkedListNode? = null
    var prev: DoublyLinkedListNode? = null

    fun addNode(node: DoublyLinkedListNode) {
        node.next = this.next
        node.prev = this
        this.next = node
    }

    fun removeNode(prevNode: DoublyLinkedListNode) {
        this.next?.prev = prevNode
        prevNode.next = this.next

    }

}
