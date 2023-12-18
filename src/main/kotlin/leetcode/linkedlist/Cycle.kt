//https://tinyurl.com/leetcode053
package leetcode.linkedlist

import java.util.Stack

fun main() {
    val head = ListNode(3)
    val node1 = ListNode(2)
    val node2 = ListNode(0)
    val tail = ListNode(-4)
    head.next = node1
    node1.next = node2
    node2.next = tail
    tail.next = node1
    println(head)
    println(hasCycle(head))
}


fun hasCycle(head: ListNode?): Boolean {
    var (slow, fast) = Pair(head, head)
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow == fast) return true
    }
    return false
}

fun linkedListToStack(head: ListNode?): Stack<Int> {
    val stack = Stack<Int>()
    var h = head
    while (h!=null) {
        stack.push(h.`val`)
        h = h.next
    }
    return stack
}