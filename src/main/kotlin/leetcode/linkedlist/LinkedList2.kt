package leetcode.linkedlist


// with sentinel nodes
data class LinkedList2(var `val`: Int) {
    var next: LinkedList2? = null
    var prev: LinkedList2? = null
}

/*
 h  -> h.next
    ^n
 n.prev = h
 n.next = h.n
 h.next.prev = n
 h.next - n
 */
fun addtoStart(head: LinkedList2, nodetoAdd: LinkedList2) {
    nodetoAdd.prev = head
    nodetoAdd.next = head.next
    head.next?.prev = nodetoAdd
    head.next = nodetoAdd
}

/*
 t.prev  -> t
        ^n
 n.next = t
 n.prev = t.prev
 t.prev.next = n
 t.prev = n
 */
fun addtoEnd(nodetoAdd: LinkedList2, tail: LinkedList2) {
    nodetoAdd.next = tail
    nodetoAdd.prev = tail.prev
    tail.prev?.next = nodetoAdd
    tail.prev = nodetoAdd
}

/*
 h  -> h.next

 n = h.next
 n.next.prev = h
 h.next = n.next

 */
fun removeFromStart(head: LinkedList2, tail: LinkedList2) {
    if(head.next == tail) return
    val nodeToRemove = head.next
    nodeToRemove?.next?.prev = head
    head.next = nodeToRemove?.next
}

/*
    t.prev - t
    n = t.prev
    t.prev = n.prev
    n.prev.next = t

 */

fun removeFromEnd(head: LinkedList2, tail: LinkedList2) {
    if(head.next == tail) return
    val nodeToRemove = tail.prev
    nodeToRemove?.prev?.next = tail
    tail.prev = nodeToRemove?.prev
}

fun main() {
    val head = LinkedList2(-1)
    val tail = LinkedList2(-1)
    head.next = tail
    tail.prev = head
}