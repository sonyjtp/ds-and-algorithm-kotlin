// http://tinyurl.com/leetcode060
package leetcode.linkedlist

fun main() {
    val n = 2
    LinkedListUtil.printElements(removeNthFromEnd(
        LinkedListUtil.buildLinkedList(1,2,3,4,5), n))
    LinkedListUtil.printElements(removeNthFromEnd2(
        LinkedListUtil.buildLinkedList(1,2,3,4,5), n))
}

// better solution
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var fast: ListNode? = dummy
    var slow: ListNode? = dummy
    for(i in 0..n){
        fast = fast?.next
    }
    while (fast != null){
        slow = slow?.next
        fast = fast.next
    }
    slow?.next = slow?.next?.next
    return dummy.next
}

// solution
fun removeNthFromEnd2(head: ListNode?, n: Int): ListNode? {
    if(head?.next == null) return null
    var curr = head
    var len = 0
    while (curr != null){
        len++
        curr = curr.next
    }
    if (len == n) return head.next
    var i = 1
    var prev: ListNode? = null
    curr = head
    while (i < len - n + 1 && curr!=null) {
        prev = curr
        curr = curr.next
        i++
    }
    prev?.next = curr?.next
    return head
}




