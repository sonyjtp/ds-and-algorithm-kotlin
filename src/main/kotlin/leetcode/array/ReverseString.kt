//https://tinyurl.com/leetcode030
package leetcode.array


fun main() {
    val str = ('a'..'z').take(50).shuffled().joinToString("").toCharArray()
    println(str)
    println(str.reversed().joinToString(""))
    reverseString(str)
}

fun reverseString(s: CharArray) {
    for(i in 0 until s.size / 2){
        s[i] = s[s.size -1 - i].also { s[s.size -1 - i] = s[i] }
    }
    println(s)
}

