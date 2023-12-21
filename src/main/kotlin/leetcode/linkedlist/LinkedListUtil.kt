package leetcode.linkedlist

object LinkedListUtil {

    fun printElements(head: ListNode?) {
        var h = head
        while (h!=null) {
            print("${ h.`val`}\t")
            h =  h.next
        }
        println()
    }

    fun buildLinkedList(vararg elements: Int):ListNode {
        var head: ListNode?  = null
        var curr: ListNode? = null
        for((idx, i) in elements.withIndex()){
            if(idx != 0) {
                curr = addNode(curr!!, ListNode(i))
            } else {
                head = ListNode(i)
                curr = head
            }
        }
        return head!!
    }

    private fun addNode(prevNode: ListNode, newNode: ListNode): ListNode {
        newNode.next = prevNode.next
        prevNode.next = newNode
        return newNode
    }

    fun removeNode(prevNode: ListNode) {
        prevNode.next = prevNode.next?.next
    }

}