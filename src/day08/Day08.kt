package day08

import readInput

fun main() {


    fun isVisible(i: Int, array: Array<IntArray>, column: Int, row: Int): Boolean {
        var aboveTrees = listOf<Int>()
        var leftTrees = listOf<Int>()
        var belowTrees = listOf<Int>()
        var rightTrees = listOf<Int>()
        for (k in 0 until row) {
            aboveTrees = aboveTrees.plus(array[column][k])
        }
        for (j in 0 until column) {
            leftTrees = leftTrees.plus(array[j][row])
        }
        for (k in row + 1 until array.size) {
            belowTrees = belowTrees.plus(array[column][k])
        }
        for (j in column + 1 until array[0].size) {
            rightTrees = rightTrees.plus(array[j][row])
        }
        if (aboveTrees.isNotEmpty() && aboveTrees.all { it < i }) {
            return true
        }
        if (leftTrees.isNotEmpty() && leftTrees.all { it < i }) {
            return true
        }
        if (belowTrees.isNotEmpty() && belowTrees.all { it < i }) {
            return true
        }
        if (rightTrees.isNotEmpty() && rightTrees.all { it < i }) {
            return true
        }
        return false
    }

    fun computeScenicScore(i: Int, array: Array<IntArray>, column: Int, row: Int): Int {
//        var aboveTrees = listOf<Int>()
//        var leftTrees = listOf<Int>()
//        var belowTrees = listOf<Int>()
//        var rightTrees = listOf<Int>()
        var scenicScoreAbove = 0
        var scenicScoreLeft = 0
        var scenicScoreBelow = 0
        var scenicScoreRight = 0
        for (k in (0 until row).reversed()) {
            if (array[column][k] < i) {
                scenicScoreAbove++
            } else {
                scenicScoreAbove++
                break
            }
        }
        for (j in (0 until column).reversed()) {
            if (array[j][row] < i) {
                scenicScoreLeft++
            } else {
                scenicScoreLeft++
                break
            }
        }
        for (k in row + 1 until array.size) {
            if (array[column][k] < i) {
                scenicScoreBelow++
            } else {
                scenicScoreBelow++
                break
            }
        }
        for (j in column + 1 until array[0].size) {
            if (array[j][row] < i) {
                scenicScoreRight++
            } else {
                scenicScoreRight++
                break
            }
        }

        return scenicScoreAbove * scenicScoreBelow * scenicScoreLeft * scenicScoreRight
    }

    fun part1(input: List<String>): Int {
        val array = Array(input.size) { IntArray(input[0].length) }
        var column = 0
        // fill the  matrix
        for ((row, i) in input.withIndex()) {
            val iterator = i.iterator()
            while (iterator.hasNext()) {
                val c = iterator.nextChar()
                array[row][column] = c.digitToInt()
                column++
            }
            column = 0
        }

        var countTrees = 0
        for (col in array.indices) {
            val row = array[col]
            for (r in row.indices) {
                if (col == 0 || col == array.size - 1) {
                    countTrees++
                } else if (r == 0 || r == row.size - 1) {
                    countTrees++
                } else {
                    if (isVisible(array[col][r], array, col, r)) countTrees++
                }
            }
        }

        return countTrees
    }

    fun part2(input: List<String>): Int {
        val array = Array(input.size) { IntArray(input[0].length) }
        var column = 0
        // fill the  matrix
        for ((row, i) in input.withIndex()) {
            val iterator = i.iterator()
            while (iterator.hasNext()) {
                val c = iterator.nextChar()
                array[row][column] = c.digitToInt()
                column++
            }
            column = 0
        }

        val scenicMatrix = Array(input.size) { IntArray(input[0].length) }

        for (col in array.indices) {
            val row = array[col]
            for (r in row.indices) {
                if (col == 0 || col == array.size - 1) {
                    scenicMatrix[col][r] = 0
                } else if (r == 0 || r == row.size - 1) {
                    scenicMatrix[col][r] = 0
                } else {
                    scenicMatrix[col][r] = computeScenicScore(array[col][r], array, col, r)
                }
            }
        }

        var maxScenic = 0
        for (i in scenicMatrix.indices) {
            for (j in 0 until scenicMatrix[0].size) {
                if (scenicMatrix[i][j] > maxScenic) {
                    maxScenic = scenicMatrix[i][j]
                }
            }
        }
        return maxScenic
    }

    val testInput =
        "30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390"

    println(part1(testInput.split("\n")))
    print(part1(readInput("08")))

    println(part2(testInput.split("\n")))
    print(part2(readInput("08")))
}