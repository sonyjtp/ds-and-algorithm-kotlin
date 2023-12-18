package leetcode.linkedlist

data class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun addNode(node: ListNode) {
        node.next = this.next
        this.next = node
    }

    fun removeNode(prevNode: ListNode) {
        prevNode.next = this.next
    }
}
