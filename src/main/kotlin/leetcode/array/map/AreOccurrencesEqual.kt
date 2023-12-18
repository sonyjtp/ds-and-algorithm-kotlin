//https://tinyurl.com/leetcode047
package leetcode.array.map

fun main() {
    val charRange = ('a'..'e')
    var size = (5..15).random()
    val s = generateSequence {
        size--
        charRange.random().takeIf {
            size > 0
        }
    }.joinToString("")
//    val s = "aaabb"
    println(s)
    println(areOccurrencesEqual(s))
    println(areOccurrencesEqual2(s))
}

fun areOccurrencesEqual(s: String): Boolean {
    val charMap = mutableMapOf<Char, Int>()
    for(chr in s) {
        charMap[chr] = charMap.getOrDefault(chr, 0) + 1
    }
    charMap.keys.forEach {
        if(charMap[it]!! != charMap[s[0]]!!) return false
    }
    return true
}
fun areOccurrencesEqual2(s: String): Boolean {
    val charMap = mutableMapOf<Char, Int>()
    for(chr in s) {
        charMap[chr] = charMap.getOrDefault(chr, 0) + 1
    }
    return charMap.values.toSet().size == 1
}

