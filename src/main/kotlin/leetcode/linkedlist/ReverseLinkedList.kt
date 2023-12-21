//https://tinyurl.com/leetcode058
package leetcode.linkedlist

/**
* class ListNode(var `val`: Int) {
*     var next: ListNode? = null
* }
*/

fun main() {
    val head = LinkedListUtil.buildLinkedList(1,2,3,4,5)
    LinkedListUtil.printElements(head)
    LinkedListUtil.printElements(reverseList(head))
}

fun reverseList(head: ListNode?): ListNode? {
    var curr = head
    var prev: ListNode? = null
    while (curr!=null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev
}

/*
1 > 2> 3 > 4
prev = null
curr                1       2   3   4
next = curr.next    2       3   4   null
curr.next = prev    null    1   2   3
prev = curr         1       2   3   4
curr = next         2       3   4   null
4 > 3 > 2 > 1

 */


