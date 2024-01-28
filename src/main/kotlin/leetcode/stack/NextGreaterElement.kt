//http://tinyurl.com/leetcode069
package leetcode.stack

import java.util.HashMap
import java.util.Stack

fun main() {
    var size = (5..10).random()
    val nums2 = generateSequence {
        size --
        (-5..10).random().takeIf {
            size > 0
        }
    }.toList().shuffled().distinct()
    val nums1 = nums2.shuffled().take((1..nums2.size).random())
    println(nums1)
    println(nums2)
    println(nextGreaterElement(nums1.toIntArray(), nums2.toIntArray()).toList())
}

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val stack = Stack<Int>()
    val nextGreaterMap = HashMap<Int, Int>(nums1.size)
    for(num in nums2) {
        while(stack.isNotEmpty() && stack.peek() < num) {
            nextGreaterMap[stack.pop()] = num
        }
        stack.push(num)
    }
    return nums1.map {
        nextGreaterMap.getOrDefault(it, -1)
    }.toIntArray()
}

