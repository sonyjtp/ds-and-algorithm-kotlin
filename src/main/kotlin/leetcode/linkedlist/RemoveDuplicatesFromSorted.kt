//https://tinyurl.com/leetcode057
package leetcode.linkedlist

fun deleteDuplicates(head: ListNode?): ListNode? {
    var dummy = head
    while(dummy!= null) {
        while(dummy.`val` == dummy.next?.`val`) {
            dummy.next = dummy.next?.next
        }
        dummy = dummy.next
    }
    return head
}
