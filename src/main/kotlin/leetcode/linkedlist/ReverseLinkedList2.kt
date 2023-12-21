//https://tinyurl.com/leetcode059
package leetcode.linkedlist

import java.util.LinkedList

/**
* class ListNode(var `val`: Int) {
*     var next: ListNode? = null
* }
*/

fun main() {
    val head = LinkedListUtil.buildLinkedList(1,2,3,4,5)
    LinkedListUtil.printElements(head)
    LinkedListUtil.printElements(reverseBetween(head, 2, 4))
}

fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    var curr = head
    var idx = 0
    val reverseList = LinkedList<Int>()
    while (curr !=null) {
        idx++
        if(idx in left..right) reverseList.add(curr.`val`)
        curr = curr.next
    }
    curr = head
    idx = 0
    while (curr!=null){
        idx++
        if(idx in left..right) curr.`val` = reverseList.removeLast()
        curr = curr.next

    }
    return head
}

