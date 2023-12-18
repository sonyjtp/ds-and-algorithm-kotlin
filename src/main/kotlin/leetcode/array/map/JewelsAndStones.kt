//https://tinyurl.com/leetcode051
package leetcode.array.map

fun main() {
    val chars  = ('a'..'e').shuffled() + ('A'..'E').shuffled()
    val jewels = chars.shuffled().take((1..5).random()).joinToString("")
    val stoneCount = (5..10).random()
    val stones =  (('a'..'e') + ('a'..'e')
            + ('A'..'E') + ('A'..'E'))
        .toList().shuffled().take(stoneCount).joinToString("")
    println(jewels)
    println(stones)
    println(numJewelsInStones(jewels, stones))
    println(numJewelsInStones2(jewels, stones))
}

fun numJewelsInStones(jewels: String, stones: String): Int {
    var jewelStoneCount = 0
    for(stone in stones) {
        if (stone in jewels) jewelStoneCount++
    }
    return jewelStoneCount
}

fun numJewelsInStones2(jewels: String, stones: String): Int {
    var jewelStoneCount = 0
    val jewelSet = BooleanArray(128)
    for(jewel in jewels){ jewelSet[jewel.code] = true }
    for(stone in stones) {
        if ( jewelSet[stone.code]) jewelStoneCount++
    }
    return jewelStoneCount
}

