//https://tinyurl.com/leetcode052
package leetcode.array.slidingwindow

import kotlin.math.max

fun main() {
    val chars = ('a'..'h')
    var size = (1..15).random()
    val s = generateSequence {
        size--
        chars.random().takeIf { size >=0 }
    }.toList().joinToString("")
    println(s)
    println(lengthOfLongestSubstring("abcabcbb"))
}

fun lengthOfLongestSubstring(s: String): Int {
    val subStr = mutableListOf<Int>()
    var left = 0
    var longest = 0
    for(right in s.indices) {
        val code = s[right].code
        if(subStr.lastIndexOf(code) >= left ) {
            left = subStr.lastIndexOf(code) + 1
        }
        subStr.add(code)
        longest = max(longest, right - left + 1)
    }
    return longest
}