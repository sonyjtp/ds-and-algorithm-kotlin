//http://tinyurl.com/leetcode041
package leetcode.array.prefixsum

import kotlin.math.max

fun main() {
    val s = ('a'..'z').shuffled().take(15).joinToString("")
//    val s = "ibpbhixfiouhdljnjfflpapptrxgcomvnb"
    val k = (5..10).random()
//    val k = 33
    println(s)
    println(k)
    println(maxVowels(s,k))
}

fun maxVowels(s: String, k: Int): Int {
    var vowelCount = 0
    for (i in 0 until k){
       if (isVowel(s[i])) vowelCount++
    }
    if (s.length == k) return vowelCount
    var maxVowels = vowelCount
    for((left, right) in (k until s.length).withIndex()) {
        if(isVowel(s[left])) vowelCount--
        if(isVowel(s[right])) vowelCount++
        maxVowels = max(maxVowels, vowelCount)
    }
    return maxVowels
}

private fun isVowel(c: Char) = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'