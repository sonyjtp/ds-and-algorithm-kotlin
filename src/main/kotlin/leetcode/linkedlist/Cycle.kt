//https://tinyurl.com/leetcode053
package leetcode.linkedlist

fun main() {
    val head = ListNode(3)
    val listNode1 = ListNode(2)
    val listNode2 = ListNode(0)
    val tail = ListNode(-4)
    head.next = listNode1
    listNode1.next = listNode2
    listNode2.next = tail
    tail.next = listNode1
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