//https://tinyurl.com/leetcode056
package leetcode.linkedlist

fun middleNodeValue(head: ListNode?): ListNode?{
    var slowPointer = head
    var fastPointer = head
    while (fastPointer?.next != null) {
        slowPointer = slowPointer?.next
        fastPointer = fastPointer.next?.next
    }
    return slowPointer!!
}