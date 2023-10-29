//https://www.algoexpert.io/questions/tournament-winner
package algoexpert.array

fun main() {
    val competitions = listOf(
        listOf("HTML", "Java"),
        listOf("Java", "Python"),
        listOf("Python", "HTML"),
        listOf("C#", "Python"),
        listOf("Java", "C#"),
        listOf("C#", "HTML")
    )

    val results = listOf(0, 1, 1, 1, 0, 1)
    println("The winner is ${tournamentWinner(competitions,results)}")
}

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    val points = mutableMapOf<String, Int>()
    var leader = ""
    for (i in competitions.indices) {
        val winner = if (results[i] == 0) competitions[i][1] else competitions[i][0]
        points[winner] = points[winner]?.let { it + 3 } ?: 3
        if (i > 0 && points[winner]!! > points[leader]!!  || i ==0) leader = winner
    }
    return leader
}




