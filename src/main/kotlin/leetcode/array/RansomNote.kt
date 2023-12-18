package leetcode.array

fun main() {
    var size1 = (3..10).random()
    var size2 = (3..5).random()
    val chars = ('a'..'f')
    val magazine = generateSequence { 
        size1--
        chars.random().takeIf { size1 >=0 }
    }.joinToString("")

    val ransomNote = generateSequence {
        size2--
        chars.random().takeIf { size2 >=0 }
    }.joinToString("")
    println(magazine)
    println(ransomNote)
    println(canConstruct(ransomNote, magazine))
    println(canConstruct2(ransomNote, magazine))
}

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val freq = IntArray(26)
    for(chr in magazine) {
        freq[chr - 'a']++
    }
    for(chr in ransomNote){
        if(freq[chr - 'a'] < 1) return false
        freq[chr - 'a']--
    }
    return true
}

fun canConstruct2(ransomNote: String, magazine: String): Boolean {
    if (magazine.length < ransomNote.length) return false
    val magMap = mutableMapOf<Char, Int>()
    val ransomMap = mutableMapOf<Char, Int>()
    for (i in magazine.indices) {
        magMap[magazine[i]] = magMap.getOrDefault(magazine[i], 0) + 1
        if (i < ransomNote.length) {
            ransomMap[ransomNote[i]] = ransomMap.getOrDefault(ransomNote[i], 0) + 1
        }
    }
    for(key in ransomMap.keys) {
        magMap[key]?.let {
            if (it < ransomMap [key]!!) return false
        } ?: return false
    }
    return true
}