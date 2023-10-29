//https://www.algoexpert.io/questions/transpose-matrix
package algoexpert.array

fun main() {
    val matrix= mutableListOf(
        mutableListOf(1,2,3),
        mutableListOf(4,5,6)
    )
    println(transposeMatrix(matrix))
}


fun transposeMatrix(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    val rowSize = matrix.size
    val colSize =  matrix[0].size
    val result = mutableListOf<MutableList<Int>>()
    for(col  in 0..<colSize) {
        val newRow = mutableListOf<Int>()
        for(row in 0..<rowSize) {
            newRow.add(matrix[row][col])
        }
        result.add(newRow)
    }
    return result
}

