//https://www.algoexpert.io/questions/non-constructible-change
package algoexpert.array


fun main() {
    val coins = listOf( 1,1,2,3,5,8,13,21,34,55,89,144,233)
    println(coins.sorted())
    println(nonConstructibleChange(coins.toMutableList()))
}

fun nonConstructibleChange(coins: MutableList<Int>): Int {
    coins.sort()
    var min = 0
    for(coin in coins) {
        if (coin > min + 1) break
        min += coin
    }
    return min + 1
}
