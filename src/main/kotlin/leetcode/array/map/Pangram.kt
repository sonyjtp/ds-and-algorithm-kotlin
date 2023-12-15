//http://tinyurl.com/leetcode043
package leetcode.array.map


fun main() {
    val sentence = "The quick brown fox jumps over the lazy dog"
    println(checkIfPangram(sentence))
}

fun checkIfPangram(sentence: String): Boolean {
    val charMap = mutableMapOf<Char, Boolean>()
    for(c in sentence) {
        charMap[c] = true
        if(charMap.size == 26) return true
    }
    return false
}