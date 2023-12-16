//http://tinyurl.com/leetcode043
package leetcode.array.set


fun main() {
    val sentence = "The quick brown fox jumps over the lazy dog"
    println(checkIfPangram(sentence))
}

fun checkIfPangram(sentence: String): Boolean {
    val charSet = mutableSetOf<Char>()
    for(c in sentence) {
        charSet.add(c)
        if(charSet.size == 26) return true
    }
    return false
}